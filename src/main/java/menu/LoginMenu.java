package menu;

import dto.LoanDTO;
import utility.ApplicationContext;
import utility.SecurityContext;

import java.time.LocalDate;
import java.util.List;

public class LoginMenu extends MainMenu {
    @Override
    public String getText() {
        return """
                1.Register Loan
                2.Refund Loan
                3.LogOut
                """;
    }

    @Override
    public void chooseAnOption() {
        switch (scanner.nextInt()) {
            case 1 -> registerLoan();
            case 2 -> refundLoan();
            case 3 -> {
                EnrollMenu enrollMenu = ApplicationContext.getEnrollMenu();
                enrollMenu.showMenu();
            }
            default -> System.out.println("Invalid Input");
        }
    }

    private void refundLoan() {
        if (studentService.isGraduated()) {
            List<LoanDTO> loanDTOS = studentService.getLoans();
            if (!loanDTOS.isEmpty()) {
                System.out.println("Enter Loan ID You Want To Pay Installment For:");
                for (LoanDTO loanDTO : loanDTOS) {
                    System.out.println("LoanID: " + loanDTO.getId());
                }
                int loanId = scanner.nextInt();
                RefundLoanMenu refundLoanMenu = new RefundLoanMenu(loanId);
                refundLoanMenu.showMenu();
            } else {
                System.out.println("You Have No Loans");
            }
        } else {
            System.out.println("Refund Panel Will Be Accessible After Graduation");
            this.showMenu();
        }
    }

    private void registerLoan() {
        RegisterLoanMenu registerLoanMenu = ApplicationContext.getRegisterLoanMenu();
        if(isInValidDate()){
        if (!studentService.isGraduated()) {
            registerLoanMenu.showMenu();
        } else {
            System.out.println("You Are Graduated");
            this.showMenu();
        }
        }else {
            System.out.println("You Cant Register Loan In This Date");
            this.showMenu();
        }
    }
    private boolean isInValidDate(){
        LocalDate currentDate = SecurityContext.getCurrentDate();
        int year = currentDate.getYear();
        LocalDate abanStartDate= LocalDate.of(year,7,30);
        LocalDate abanEndDate = LocalDate.of(year,8,8);
        LocalDate bahmanStartDate = LocalDate.of(year,11,24);
        LocalDate bahmanEndDate =LocalDate.of(year,12,2);
        return (currentDate.isAfter(abanStartDate) && currentDate.isBefore(abanEndDate)) ||
                currentDate.isAfter(bahmanStartDate) && currentDate.isBefore(bahmanEndDate);
    }
}
