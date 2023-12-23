package repository;

import base.repository.BaseEntityRepository;
import entity.enumeration.GradeLevel;
import entity.loanCategory.LoanCategory;

import java.util.Optional;

public interface LoanCategoryRepository<T extends LoanCategory> extends BaseEntityRepository<T,Integer> {
    Optional<LoanCategory> findLoanCategoryByGradeLevel(GradeLevel gradeLevel);
}
