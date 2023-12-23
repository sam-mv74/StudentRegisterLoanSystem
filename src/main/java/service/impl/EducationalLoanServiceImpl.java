package service.impl;

import entity.Installment;
import entity.Student;
import entity.loan.EducationalLoan;
import repository.EducationalLoanRepository;
import service.EducationalLoanCategoryService;
import service.EducationalLoanService;
import service.conditions.EducationalLoanCondition;
import utility.ApplicationContext;
import utility.SecurityContext;

import java.util.List;

public class EducationalLoanServiceImpl extends LoanServiceImpl<EducationalLoan, EducationalLoanRepository> implements EducationalLoanService {
    public EducationalLoanServiceImpl(EducationalLoanRepository repository) {
        super(repository);
    }

    @Override
    public Double getLoanAmount() {
        Student student = SecurityContext.getCurrentStudent();
        EducationalLoanCategoryService educationalLoanCategoryService = ApplicationContext.getEducationalLoanCategoryService();
        return educationalLoanCategoryService.findEducationalLoanCategoryByGradeLevel(student.getGradeLevel()).getAmount();
    }

    @Override
    public void registerEducationalLoan() {
        Student student = SecurityContext.getCurrentStudent();
        EducationalLoan educationalLoan = new EducationalLoan();
        educationalLoan.setStudent(student);
        educationalLoan.setRegistrationDate(SecurityContext.getCurrentDate());
        EducationalLoanCategoryService educationalLoanCategoryService = ApplicationContext.getEducationalLoanCategoryService();
        educationalLoan.setLoanCategory(educationalLoanCategoryService.findEducationalLoanCategoryByGradeLevel(student.getGradeLevel()));
        List<Installment> installments = calculateInstallments();
        for (Installment installment : installments) {
            educationalLoan.addInstallment(installment);
        }
        repository.saveOrUpdate(educationalLoan);
    }

    @Override
    public List<String> checkQualification() {
        return EducationalLoanCondition.studentHasAllConditions();
    }

}
