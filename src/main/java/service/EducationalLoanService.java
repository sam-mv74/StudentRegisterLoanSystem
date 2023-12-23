package service;

import entity.loan.EducationalLoan;
public interface EducationalLoanService extends LoanService<EducationalLoan>{

    void registerEducationalLoan();
}
