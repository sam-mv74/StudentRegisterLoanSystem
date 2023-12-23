package service;

import entity.enumeration.GradeLevel;
import entity.loanCategory.TuitionLoanCategory;

public interface TuitionLoanCategoryService extends LoanCategoryService<TuitionLoanCategory> {
    TuitionLoanCategory findTuitionLoanCategoryByGradeLevel(GradeLevel gradeLevel);
}
