package service.impl;

import entity.Installment;
import entity.Student;
import entity.loan.TuitionLoan;
import repository.TuitionLoanRepository;
import service.TuitionLoanCategoryService;
import service.TuitionLoanService;
import service.conditions.TuitionLoanCondition;
import utility.ApplicationContext;
import utility.SecurityContext;

import java.util.List;

public class TuitionLoanServiceImpl extends LoanServiceImpl<TuitionLoan, TuitionLoanRepository> implements TuitionLoanService {
    public TuitionLoanServiceImpl(TuitionLoanRepository repository) {
        super(repository);
    }

    @Override
    public Double getLoanAmount() {
        Student student = SecurityContext.getCurrentStudent();
        TuitionLoanCategoryService tuitionLoanCategoryService = ApplicationContext.getTuitionLoanCategoryService();
        return tuitionLoanCategoryService.findTuitionLoanCategoryByGradeLevel(student.getGradeLevel()).getAmount();
    }

    @Override
    public void registerTuitionLoan() {
        Student student = SecurityContext.getCurrentStudent();
        List<Installment> installments = calculateInstallments();
        TuitionLoan tuitionLoan = new TuitionLoan();
        tuitionLoan.setStudent(student);
        tuitionLoan.setRegistrationDate(SecurityContext.getCurrentDate());
        TuitionLoanCategoryService tuitionLoanCategoryService = ApplicationContext.getTuitionLoanCategoryService();
        tuitionLoan.setLoanCategory(tuitionLoanCategoryService.findTuitionLoanCategoryByGradeLevel(student.getGradeLevel()));
        for (Installment installment : installments) {
            tuitionLoan.addInstallment(installment);
        }
        repository.saveOrUpdate(tuitionLoan);
    }

    @Override
    public List<String> checkQualification() {
        return TuitionLoanCondition.studentHasAllConditions();
    }
}
