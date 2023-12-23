package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.Installment;
import repository.InstallmentRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

public class InstallmentRepositoryImpl extends BaseEntityRepositoryImpl<Installment, Integer> implements InstallmentRepository {
    public InstallmentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Installment> getEntityClass() {
        return Installment.class;
    }

    @Override
    public List<Installment> findByLoanId(int loanId) {
        try {
            String hql = "select i from Installment i where i.loan.id= :loanId";
            TypedQuery<Installment> query = entityManager.createQuery(hql, Installment.class);
            query.setParameter("loanId", loanId);
            return query.getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
