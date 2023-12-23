package repository.impl;

import entity.loanCategory.TuitionLoanCategory;
import repository.TuitionLoanCategoryRepository;

import javax.persistence.EntityManager;

public class TuitionLoanCategoryRepositoryImpl extends LoanCategoryRepositoryImpl<TuitionLoanCategory> implements TuitionLoanCategoryRepository {
    public TuitionLoanCategoryRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<TuitionLoanCategory> getEntityClass() {
        return TuitionLoanCategory.class;
    }


}
