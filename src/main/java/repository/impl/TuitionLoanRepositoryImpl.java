package repository.impl;

import entity.loan.TuitionLoan;
import repository.TuitionLoanRepository;

import javax.persistence.EntityManager;

public class TuitionLoanRepositoryImpl extends LoanRepositoryImpl<TuitionLoan> implements TuitionLoanRepository {
    public TuitionLoanRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<TuitionLoan> getEntityClass() {
        return TuitionLoan.class;
    }
}
