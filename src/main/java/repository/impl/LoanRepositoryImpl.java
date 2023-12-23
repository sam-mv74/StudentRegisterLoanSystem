package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.Student;
import entity.loan.Loan;
import repository.LoanRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class LoanRepositoryImpl<T extends Loan> extends BaseEntityRepositoryImpl<T, Integer> implements LoanRepository<T> {
    public LoanRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<Loan> findByStudent(Student student) {
        String hql = "select l from " + getEntityClass().getSimpleName() + " l where l.student = :student";
        TypedQuery<Loan> query = entityManager.createQuery(hql, Loan.class);
        query.setParameter("student", student);
        return query.getResultList();
    }

    @Override
    public abstract Class<T> getEntityClass();
}
