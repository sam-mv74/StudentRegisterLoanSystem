package service;

import dto.HousingLoanRegistrationDTO;
import entity.enumeration.GradeLevel;
import entity.loan.HousingLoan;

import java.util.List;

public interface HousingLoanService extends LoanService<HousingLoan> {

    void registerHousingLoan(HousingLoanRegistrationDTO housingLoanDTO);


    List<String> addStudentHousingLoanDetails(HousingLoanRegistrationDTO housingLoanDTO);

    Boolean existByStudentNationalCodeAndGrade(Long nationalCode, GradeLevel gradeLevel);
}
