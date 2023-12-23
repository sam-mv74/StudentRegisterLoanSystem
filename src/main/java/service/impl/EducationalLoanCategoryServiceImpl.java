package service.impl;

import entity.enumeration.GradeLevel;
import entity.loanCategory.EducationalLoanCategory;
import entity.loanCategory.LoanCategory;
import repository.EducationalLoanCategoryRepository;
import service.EducationalLoanCategoryService;

import java.util.Optional;

public class EducationalLoanCategoryServiceImpl extends LoanCategoryServiceImpl<EducationalLoanCategory, EducationalLoanCategoryRepository> implements EducationalLoanCategoryService {
    public EducationalLoanCategoryServiceImpl(EducationalLoanCategoryRepository repository) {
        super(repository);
    }

    @Override
    public EducationalLoanCategory findEducationalLoanCategoryByGradeLevel(GradeLevel gradeLevel) {
        Optional<LoanCategory> loanCategoryByGradeLevel = findLoanCategoryByGradeLevel(gradeLevel);
        return (EducationalLoanCategory) loanCategoryByGradeLevel.orElse(new EducationalLoanCategory());
    }
}
