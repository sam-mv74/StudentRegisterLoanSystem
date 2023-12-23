package menu;

import dto.CreditCardDTO;
import service.CreditCardService;
import utility.ApplicationContext;

import java.util.List;

public class PaymentMenu extends RefundLoanMenu {
    int installmentId;

    public PaymentMenu() {

    }

    public PaymentMenu(int loanId, Integer id) {
        super(loanId);
        this.installmentId = id;
    }

    @Override
    public String getText() {
        return """
                1.Pay
                2.Cancel
                """;
    }

    @Override
    void chooseAnOption() {
        switch (scanner.nextInt()) {
            case 1 -> pay();
            case 2 -> {
                RefundLoanMenu refundLoanMenu = new RefundLoanMenu(getLoanId());
                refundLoanMenu.showMenu();
            }
            default -> {
                System.out.println("Invalid Input");
                this.showMenu();
            }
        }
    }

    public void pay() {
        CreditCardService creditCardService = ApplicationContext.getCreditCardService();
        CreditCardDTO creditCardDetails = getCreditCardDetails();
        List<String> results = creditCardService.existByCardDetails(creditCardDetails);
        if (results.isEmpty()) {
            System.out.println("Payment Is Successfully Done");
            installmentService.updateById(installmentId);
            RefundLoanMenu refundLoanMenu = new RefundLoanMenu(getLoanId());
            refundLoanMenu.showMenu();
        } else {
            System.out.println(results);
        }
    }
}
