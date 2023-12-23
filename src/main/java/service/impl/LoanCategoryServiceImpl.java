package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.enumeration.GradeLevel;
import entity.loanCategory.LoanCategory;
import repository.LoanCategoryRepository;
import service.LoanCategoryService;

import java.util.Optional;

public abstract class LoanCategoryServiceImpl<T extends LoanCategory, R extends LoanCategoryRepository<T>> extends BaseEntityServiceImpl<T, Integer, R>
        implements LoanCategoryService<T> {
    public LoanCategoryServiceImpl(R repository) {
        super(repository);
    }

    public Optional<LoanCategory> findLoanCategoryByGradeLevel(GradeLevel gradeLevel) {
        return repository.findLoanCategoryByGradeLevel(gradeLevel);
    }
}
