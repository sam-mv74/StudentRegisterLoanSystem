package service.conditions;

import entity.Student;
import entity.loan.HousingLoan;
import entity.loan.Loan;
import service.HousingLoanService;
import utility.ApplicationContext;
import utility.SecurityContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HousingLoanCondition {

    public static List<String> studentHasAllConditions() {
        Student currentStudent = SecurityContext.getCurrentStudent();
        List<String> results = Arrays.asList(studentHasActiveLoan(currentStudent),
                studentIsMarried(currentStudent), studentIsInDorm(currentStudent),
                loanNotRegisteredForSpouse(currentStudent));
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
            if (loan instanceof HousingLoan && loan.getStudent().getGradeLevel().equals(student.getGradeLevel()))
                return "You Have Already Taken This Loan In This Grade";
        }
        return "";
    }

    public static String studentIsMarried(Student student) {
        if (!student.getIsMarried())
            return "You Have To Be Married For Taking This Loan";
        return "";
    }

    public static String studentIsInDorm(Student student) {
        if (student.getIsInDorm())
            return "You Have To Be Not In Dorm";
        return "";
    }

    public static String loanNotRegisteredForSpouse(Student student) {
        HousingLoanService housingLoanService = ApplicationContext.getHousingLoanService();
        if (housingLoanService.existByStudentNationalCodeAndGrade(student.getSpouse().getNationalCode(), student.getGradeLevel()))
            return "Your Spouse Has Already Taken This Loan";
        return "";
    }
}
