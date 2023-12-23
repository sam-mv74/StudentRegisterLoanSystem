package service.conditions;


import entity.Student;
import entity.loan.EducationalLoan;
import entity.loan.Loan;
import utility.SecurityContext;

import java.util.ArrayList;
import java.util.List;

public class EducationalLoanCondition {
    public static List<String> studentHasAllConditions() {
        Student currentStudent = SecurityContext.getCurrentStudent();
        List<String> results = List.of(studentHasActiveLoan(currentStudent));
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
            if (loan instanceof EducationalLoan && loan.getRegistrationDate().getYear() == SecurityContext.getCurrentDate().getYear())
                return "You Have Already Taken This Loan In Current Term";
        }
        return "";
    }
}
