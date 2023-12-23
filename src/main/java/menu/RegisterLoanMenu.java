package menu;

import dto.CreditCardDTO;
import service.CreditCardService;
import utility.ApplicationContext;

import java.util.List;
public class RegisterLoanMenu extends LoanMenu {
    @Override
    public String getText() {
        return """
                1.Educational Loan
                2.Tuition Loan
                3.Housing Loan
                4.Back
                """;
    }

    @Override
    void chooseAnOption() {
        switch (scanner.nextInt()) {
            case 1 -> educationalLoan();
            case 2 -> tuitionLoan();
            case 3 -> housingLoan();
            case 4 -> {
                LoginMenu loginMenu =ApplicationContext.getLoginMenu();
                loginMenu.showMenu();
            }
            default-> System.out.println("Invalid Input");
        }
    }

    private void housingLoan() {
        RegisterHousingLoanMenu registerHousingLoanMenu = ApplicationContext.getRegisterHousingLoanMenu();
        registerHousingLoanMenu.registerHousingLoan();
    }

    private void tuitionLoan() {
        RegisterTuitionLoanMenu registerTuitionLoanMenu = ApplicationContext.getRegisterTuitionLoanMenu();
        registerTuitionLoanMenu.registerTuitionLoan();
    }

    private void educationalLoan() {
        RegisterEducationalLoanMenu registerEducationalLoanMenu = ApplicationContext.getRegisterEducationalLoanMenu();
        registerEducationalLoanMenu.registerEducationalLoan();
    }

    protected void showLoanAmount(Double loanAmount) {
        System.out.println("Loan Amount For You:");
        System.out.println(loanAmount);
        System.out.println("""
                1.Ok
                2.Cancel
                """);
        int choice = scanner.nextInt();
        if (choice == 1) {
            addCreditCard();
        } else {
            this.showMenu();
        }
    }

    protected void addCreditCard() {
        boolean flg = true;
        while (flg) {
            CreditCardDTO creditCardDTO = getCreditCardDetails();
            CreditCardService creditCardService = ApplicationContext.getCreditCardService();
            List<String> results = creditCardService.registerCard(creditCardDTO);
            if (results.isEmpty()) {
                flg = false;
            } else {
                System.out.println(results);
            }
        }
    }
}
