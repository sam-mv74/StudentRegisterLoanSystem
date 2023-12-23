package repository;

import entity.enumeration.GradeLevel;
import entity.loan.HousingLoan;

public interface HousingLoanRepository extends LoanRepository<HousingLoan> {
    Boolean existByStudentNationalCodeAndGrade(Long nationalCode, GradeLevel gradeLevel);
}
