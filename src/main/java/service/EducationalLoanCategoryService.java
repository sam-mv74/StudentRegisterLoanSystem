package service;

import entity.enumeration.GradeLevel;
import entity.loanCategory.EducationalLoanCategory;

public interface EducationalLoanCategoryService extends LoanCategoryService<EducationalLoanCategory> {
    EducationalLoanCategory findEducationalLoanCategoryByGradeLevel(GradeLevel gradeLevel);

}
