package service;

import dto.LoanDTO;
import dto.StudentRegistrationDTO;
import entity.Student;

import java.time.LocalDate;
import java.util.List;

public interface StudentService extends PersonService<Student> {
    Boolean login(String username, String password);

    String generatePassword();

    List<String> registerStudent(StudentRegistrationDTO studentRegistrationDTO);

    boolean isGraduated();

    LocalDate graduationDate(Student student);

    List<LoanDTO> getLoans();
}
