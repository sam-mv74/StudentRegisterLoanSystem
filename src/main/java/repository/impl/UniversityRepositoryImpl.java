package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.University;
import repository.UniversityRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class UniversityRepositoryImpl extends BaseEntityRepositoryImpl<University, Integer> implements UniversityRepository {
    public UniversityRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<University> getEntityClass() {
        return University.class;
    }

    @Override
    public Optional<University> findByName(String universityName) {
        try {
            String hql = "select u from University u where name = :universityName";
            TypedQuery<University> query = entityManager.createQuery(hql, University.class);
            query.setParameter("universityName", universityName);
            return Optional.of(query.getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
