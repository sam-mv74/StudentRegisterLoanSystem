package utility;

import lombok.Getter;
import entity.Student;

import java.time.LocalDate;

public class SecurityContext {

    private SecurityContext() {
    }

    @Getter
    private static Student currentStudent;
    @Getter
    public static LocalDate currentDate;

    public static void fillStudentContext(Student student) {
        currentStudent = student;
    }

    public static void fillDateContext(LocalDate date) {
        currentDate = date;
    }
}
