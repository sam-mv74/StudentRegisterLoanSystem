package repository.impl;

import entity.loanCategory.EducationalLoanCategory;
import repository.EducationalLoanCategoryRepository;

import javax.persistence.EntityManager;

public class EducationalLoanCategoryRepositoryImpl extends LoanCategoryRepositoryImpl<EducationalLoanCategory> implements EducationalLoanCategoryRepository {
    public EducationalLoanCategoryRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<EducationalLoanCategory> getEntityClass() {
        return EducationalLoanCategory.class;
    }

}
