package menu;

import service.*;
import utility.ApplicationContext;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class MainMenu {
    StudentService studentService = ApplicationContext.getStudentService();
    HousingLoanService housingLoanService = ApplicationContext.getHousingLoanService();
    TuitionLoanService tuitionLoanService = ApplicationContext.getTuitionLoanService();
    EducationalLoanService educationalLoanService = ApplicationContext.getEducationalLoanService();
    InstallmentService installmentService = ApplicationContext.getInstallmentService();
    protected Scanner scanner = new Scanner(System.in);
    protected boolean flag = true;

    public void showMenu() {
        while (flag) {
            System.out.println(getText());
            try {
                chooseAnOption();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Wrong Input Format");
            }
        }
    }

    public abstract String getText();

    abstract void chooseAnOption();

}
