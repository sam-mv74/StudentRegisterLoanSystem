package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.Installment;
import entity.Student;
import entity.loan.Loan;
import repository.LoanRepository;
import service.LoanService;
import service.StudentService;
import utility.ApplicationContext;
import utility.SecurityContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class LoanServiceImpl<T extends Loan, R extends LoanRepository<T>> extends BaseEntityServiceImpl<T, Integer, R>
        implements LoanService<T> {
    public LoanServiceImpl(R repository) {
        super(repository);
    }

    public List<Installment> calculateInstallments() {
        StudentService studentService = ApplicationContext.getStudentService();
        Student currentStudent = SecurityContext.getCurrentStudent();
        LocalDate graduationDate = studentService.graduationDate(currentStudent);
        LocalDate repaymentDate = graduationDate.plusMonths(1);
        List<Installment> installments = new ArrayList<>();
        Double loanAmount = getLoanAmount();
        double repayAmount = (loanAmount * 4) / 100 + loanAmount;
        int count = 1;
        for (int i = 0; i < 5; i++) {
            double amount = (repayAmount / 31) * Math.pow(2, i);
            for (int j = 0; j < 12; j++) {
                Installment installment = new Installment();
                installment.setNumber(count++);
                installment.setAmount(amount / 12);
                installment.setDueDate(repaymentDate);
                installments.add(installment);
                repaymentDate = repaymentDate.plusMonths(1);
            }
        }
        return installments;
    }

    public abstract Double getLoanAmount();

}
