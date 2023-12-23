package service.conditions;

import entity.Student;
import entity.enumeration.UniversityType;
import entity.loan.Loan;
import entity.loan.TuitionLoan;
import utility.SecurityContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TuitionLoanCondition {
    public static List<String> studentHasAllConditions() {
        Student currentStudent = SecurityContext.getCurrentStudent();
        List<String> results = Arrays.asList(studentHasActiveLoan(currentStudent),
                universityHasTuition(currentStudent));
        List<String> conditionResult = new ArrayList<>();
        for (String result : results) {
            if (!result.isBlank()) {
                conditionResult.add(result);
            }
        }
        return conditionResult;
    }

    public static String studentHasActiveLoan(Student student) {
        List<Loan> loans = student.getLoans();
        for (Loan loan : loans) {
            if (loan instanceof TuitionLoan && loan.getRegistrationDate().getYear() == SecurityContext.getCurrentDate().getYear())
                return "You Have Already Taken This Loan In Current Term";
        }
        return "";
    }

    public static String universityHasTuition(Student student) {
        if (student.getUniversity().getUniversityType().equals(UniversityType.DAY_TIME_PUBLIC)) {
            return "University Isn't Monetary";
        }
        return "";
    }
}
