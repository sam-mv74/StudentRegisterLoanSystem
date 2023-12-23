package service;

import base.service.BaseEntityService;
import entity.loan.Loan;

import java.util.List;

public interface LoanService<T extends Loan> extends BaseEntityService<T, Integer> {
    List<String> checkQualification();

    Double getLoanAmount();
}
