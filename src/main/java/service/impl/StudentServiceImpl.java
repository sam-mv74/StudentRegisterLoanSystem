package service.impl;

import dto.LoanDTO;
import dto.StudentRegistrationDTO;
import entity.Address;
import entity.City;
import entity.Student;
import entity.University;
import entity.enumeration.CityType;
import entity.enumeration.GradeLevel;
import entity.enumeration.UniversityType;
import entity.loan.Loan;
import repository.StudentRepository;
import service.CityService;
import service.StudentService;
import service.UniversityService;
import service.validation.StudentValidation;
import utility.ApplicationContext;
import utility.SecurityContext;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class StudentServiceImpl extends PersonServiceImpl<Student, StudentRepository> implements StudentService {
    public StudentServiceImpl(StudentRepository repository) {
        super(repository);
    }

    @Override
    public Boolean login(String username, String password) {
        Optional<Student> student = repository.findByUserNameAndPassword(username, password);
        if (student.isPresent()) {
            SecurityContext.fillStudentContext(student.get());
            return true;
        }
        return false;
    }

    @Override
    public String generatePassword() {
        // Set the password length
        int passwordLength = 8;

        // Use SecureRandom for cryptographic-strength random numbers
        SecureRandom random = new SecureRandom();

        // Build the password using regex pattern
        String passwordRegex = "(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%&])(?=.*\\d)[A-Za-z@#$%&\\d]{" + passwordLength + "}";
        StringBuilder passwordBuilder = new StringBuilder(passwordLength);

        while (!passwordBuilder.toString().matches(passwordRegex)) {
            passwordBuilder.setLength(0); // Clear the StringBuilder

            // Fill the password with random characters
            for (int i = 0; i < passwordLength; i++) {
                char randomChar = (char) random.nextInt(128); // Using ASCII range for simplicity
                passwordBuilder.append(randomChar);
            }
        }
        return passwordBuilder.toString();
    }

    @Override
    public List<String> registerStudent(StudentRegistrationDTO studentRegistrationDTO) {
        List<String> results = StudentValidation.validateStudentRegistrationDTO(studentRegistrationDTO);
        boolean isValid = results.isEmpty();
        if (isValid) {
            Student student = new Student();
            student.setFirstName(studentRegistrationDTO.getFirstName());
            student.setLastName(studentRegistrationDTO.getLastName());
            student.setMotherName(studentRegistrationDTO.getMotherName());
            student.setFatherName(studentRegistrationDTO.getFatherName());
            student.setCertificateNumber(studentRegistrationDTO.getCertificateNumber());
            student.setNationalCode(Long.parseLong(studentRegistrationDTO.getNationalCode()));
            student.setDateOfBirth(convertBirthDate(studentRegistrationDTO));
            student.setAddress(fillAddressContext(studentRegistrationDTO));
            student.setUniversity(fillUniversityContext(studentRegistrationDTO));
            student.setGradeLevel(GradeLevel.valueOf(studentRegistrationDTO.getGradeLevel().toUpperCase()));
            student.setYearOfEntry(Integer.parseInt(studentRegistrationDTO.getYearOfEntry()));
            student.setStudentNumber(Long.parseLong(studentRegistrationDTO.getStudentNumber()));
            student.setIsMarried(studentRegistrationDTO.getIsMarried().equals("y"));
            student.setIsInDorm(studentRegistrationDTO.getIsInDorm().equals("y"));
            student.setUsername(studentRegistrationDTO.getNationalCode());
            student.setPassword(generatePassword());
            repository.saveOrUpdate(student);
            SecurityContext.fillStudentContext(student);
        }
        return results;
    }

    @Override
    public boolean isGraduated() {
        Student student = SecurityContext.getCurrentStudent();
        LocalDate graduationDate = graduationDate(student);
        LocalDate currentDate = SecurityContext.getCurrentDate();
        return currentDate.isAfter(graduationDate);
    }

    @Override
    public LocalDate graduationDate(Student student) {
        GradeLevel gradeLevel = student.getGradeLevel();
        int duration = gradeLevel.getDuration();
        int graduationYear = duration + student.getYearOfEntry();
        return LocalDate.of(graduationYear, 7, 1);
    }

    @Override
    public List<LoanDTO> getLoans() {
        Student currentStudent = SecurityContext.getCurrentStudent();
        List<Loan> loans = currentStudent.getLoans();
        List<LoanDTO> loanDTOS = new ArrayList<>();
        if (!loans.isEmpty()) {
            for (Loan loan : loans) {
                LoanDTO loanDTO = new LoanDTO();
                loanDTO.setId(loan.getId());
                loanDTO.setRegistrationDate(loan.getRegistrationDate());
                loanDTOS.add(loanDTO);
            }
        }
        return loanDTOS;
    }

    private University fillUniversityContext(StudentRegistrationDTO studentRegistrationDTO) {
        String universityName = studentRegistrationDTO.getUniversityName();
        UniversityType universityType = UniversityType.valueOf(studentRegistrationDTO.getUniversityType());
        UniversityService universityService = ApplicationContext.getUniversityService();
        Optional<University> existingUniversity = universityService.findByName(universityName);
        return existingUniversity.orElse(new University(universityName, universityType));
    }

    private Address fillAddressContext(StudentRegistrationDTO studentRegistrationDTO) {
        String cityName = studentRegistrationDTO.getCity().toUpperCase();
        CityService cityService = ApplicationContext.getCityService();
        Optional<City> existingCity = cityService.findByName(cityName);
        return new Address(existingCity.orElse(new City(cityName, CityType.OTHER)));
    }

    private LocalDate convertBirthDate(StudentRegistrationDTO studentRegistrationDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(studentRegistrationDTO.getDateOfBirth(), formatter);
    }


}
