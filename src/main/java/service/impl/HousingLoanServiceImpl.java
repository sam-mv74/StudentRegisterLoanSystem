package service.impl;

import dto.HousingLoanRegistrationDTO;
import entity.*;
import entity.enumeration.GradeLevel;
import entity.loan.HousingLoan;
import entity.loanCategory.HousingLoanCategory;
import entity.loanCategory.LoanCategory;
import repository.HousingLoanRepository;
import service.HousingLoanCategoryService;
import service.HousingLoanService;
import service.StudentService;
import service.conditions.HousingLoanCondition;
import service.validation.HousingLoanDetailsValidation;
import utility.ApplicationContext;
import utility.SecurityContext;

import java.util.List;
import java.util.Optional;

public class HousingLoanServiceImpl extends LoanServiceImpl<HousingLoan, HousingLoanRepository> implements HousingLoanService {
    public HousingLoanServiceImpl(HousingLoanRepository repository) {
        super(repository);
    }

    @Override
    public void registerHousingLoan(HousingLoanRegistrationDTO housingLoanDTO) {
        Student student = SecurityContext.getCurrentStudent();
        HousingLoan housingLoan = new HousingLoan();
        housingLoan.setRentalNumber(housingLoanDTO.getRentalNumber());
        housingLoan.setStudent(student);
        housingLoan.setRegistrationDate(SecurityContext.getCurrentDate());
        HousingLoanCategoryService housingLoanCategoryService = ApplicationContext.getHousingLoanCategoryService();
        Optional<HousingLoanCategory> housingLoanCategoryByCityType = housingLoanCategoryService.findHousingLoanCategoryByCityType(student.getAddress().getCity().getCityType());
        housingLoanCategoryByCityType.ifPresent(housingLoan::setLoanCategory);
        List<Installment> installments = calculateInstallments();
        for (Installment installment : installments) {
            housingLoan.addInstallment(installment);
        }
        repository.saveOrUpdate(housingLoan);

    }

    @Override
    public List<String> addStudentHousingLoanDetails(HousingLoanRegistrationDTO housingLoanDTO) {
        List<String> results = HousingLoanDetailsValidation.validateHousingLoanDetails(housingLoanDTO);
        if (results.isEmpty()) {
            Person spouse = new Person();
            spouse.setFirstName(housingLoanDTO.getSpouseFirstName());
            spouse.setLastName(housingLoanDTO.getSpouseLastName());
            spouse.setNationalCode(Long.parseLong(housingLoanDTO.getSpouseNationalCode()));
            spouse.setIsMarried(true);

            Student student = SecurityContext.getCurrentStudent();

            Address address = student.getAddress();
            address.setAddress(housingLoanDTO.getAddress());
            address.setPostalCode(Long.parseLong(housingLoanDTO.getPostalCode()));
            address.setPhoneNumber(housingLoanDTO.getPhoneNumber());

            student.setSpouse(spouse);
            student.setAddress(address);
            StudentService studentService = ApplicationContext.getStudentService();
            studentService.saveOrUpdate(student);
        }
        return results;
    }

    @Override
    public List<String> checkQualification() {
        return HousingLoanCondition.studentHasAllConditions();
    }

    @Override
    public Double getLoanAmount() {
        Student student = SecurityContext.getCurrentStudent();
        HousingLoanCategoryService housingLoanCategoryService = ApplicationContext.getHousingLoanCategoryService();
        Optional<HousingLoanCategory> housingLoanCategoryByCityType = housingLoanCategoryService.findHousingLoanCategoryByCityType(student.getAddress().getCity().getCityType());
        return housingLoanCategoryByCityType.map(LoanCategory::getAmount).orElse(null);
    }

    @Override
    public Boolean existByStudentNationalCodeAndGrade(Long nationalCode, GradeLevel gradeLevel) {
        return repository.existByStudentNationalCodeAndGrade(nationalCode, gradeLevel);
    }

}
