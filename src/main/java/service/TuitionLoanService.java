package service;

import entity.loan.TuitionLoan;

public interface TuitionLoanService extends LoanService<TuitionLoan> {
    void registerTuitionLoan();

}
