package service.impl;

import entity.enumeration.GradeLevel;
import entity.loanCategory.LoanCategory;
import entity.loanCategory.TuitionLoanCategory;
import repository.TuitionLoanCategoryRepository;
import service.TuitionLoanCategoryService;

import java.util.Optional;

public class TuitionLoanCategoryServiceImpl extends LoanCategoryServiceImpl<TuitionLoanCategory, TuitionLoanCategoryRepository> implements TuitionLoanCategoryService {
    public TuitionLoanCategoryServiceImpl(TuitionLoanCategoryRepository repository) {
        super(repository);
    }

    @Override
    public TuitionLoanCategory findTuitionLoanCategoryByGradeLevel(GradeLevel gradeLevel) {
        Optional<LoanCategory> loanCategoryByGradeLevel = findLoanCategoryByGradeLevel(gradeLevel);
        return (TuitionLoanCategory) loanCategoryByGradeLevel.orElse(new TuitionLoanCategory());
    }
}
