package repository.impl;

import entity.loan.EducationalLoan;
import repository.EducationalLoanRepository;

import javax.persistence.EntityManager;

public class EducationalLoanRepositoryImpl extends LoanRepositoryImpl<EducationalLoan> implements EducationalLoanRepository {
    public EducationalLoanRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<EducationalLoan> getEntityClass() {
        return EducationalLoan.class;
    }
}
