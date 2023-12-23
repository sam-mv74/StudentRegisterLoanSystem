package base.repository.impl;

import base.entity.BaseEntity;
import base.repository.BaseEntityRepository;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

@SuppressWarnings("unused")
@RequiredArgsConstructor
public abstract class BaseEntityRepositoryImpl<T extends BaseEntity<ID>, ID extends Serializable> implements BaseEntityRepository<T, ID> {

    protected final EntityManager entityManager;

    @Override
    public void saveOrUpdate(T entity) {
        try {
            beginTransaction();
            saveWithoutTransaction(entity);
            commitTransaction();
            entityManager.clear();
        } catch (Exception e) {
            e.printStackTrace();
            rollBack();

        }
    }


    public void saveWithoutTransaction(T entity) {
        if (entity.getId() == null) {
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }
    }


    @Override
    public void delete(ID id) {
        try {
            beginTransaction();
            T t = entityManager.find(getEntityClass(), id);
            entityManager.remove(t);
            commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            rollBack();

        }
    }


    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(entityManager.find(getEntityClass(), id));
    }


    @Override
    public Collection<T> findAll() {

        return entityManager.createQuery(
                "FROM " + getEntityClass().getSimpleName(), getEntityClass()
        ).getResultList();

    }

    @Override
    public boolean existsById(ID id) {
        TypedQuery<Long> query = entityManager.createQuery(
                "select count(t) from " + getEntityClass().getSimpleName() + " t where t.id = :id", Long.class
        );
        query.setParameter("id", id);
        return query.getSingleResult() > 0;
    }

    @Override
    public void beginTransaction() {
        if (!entityManager.getTransaction().isActive())
            entityManager.getTransaction().begin();
    }

    @Override
    public void commitTransaction() {
        if (entityManager.getTransaction().isActive())
            entityManager.getTransaction().commit();
    }

    @Override
    public void rollBack() {
        if (entityManager.getTransaction().isActive())
            entityManager.getTransaction().rollback();
    }

    public abstract Class<T> getEntityClass();

}