package menu;

import dto.InstallmentDTO;
import lombok.Getter;
import utility.ApplicationContext;

import java.util.List;

public class RefundLoanMenu extends LoanMenu {
    @Getter
    private int loanId;

    public RefundLoanMenu(int loanId) {
        this.loanId = loanId;
    }

    public RefundLoanMenu() {
    }

    @Override
    public String getText() {

        return """
                1.Payed Installments
                2.UnPayed Installments
                3.Pay Installments
                4.Back
                """;
    }

    @Override
    void chooseAnOption() {
        switch (scanner.nextInt()) {
            case 1 -> payedInstallments();
            case 2 -> unPayedInstallments();
            case 3 -> payInstallments();
            case 4 -> {
                LoginMenu loginMenu = ApplicationContext.getLoginMenu();
                loginMenu.showMenu();
            }
            default -> System.out.println("Invalid Input");
        }
    }

    public void unPayedInstallments() {
        List<InstallmentDTO> installmentDTOS = installmentService.unPayedInstallments(loanId);
        if (!installmentDTOS.isEmpty()) {
            for (InstallmentDTO installmentDTO : installmentDTOS) {
                System.out.println(installmentDTO.getNumber() + "- " + installmentDTO.getDueDate() + " " + installmentDTO.getAmount());
            }
        } else
            System.out.println("You Have No UnPayed Installments");
        this.showMenu();
    }

    public void payedInstallments() {
        List<InstallmentDTO> installmentDTOS = installmentService.payedInstallments(loanId);
        if (!installmentDTOS.isEmpty()) {
            for (InstallmentDTO installmentDTO : installmentDTOS) {
                System.out.println(installmentDTO.getNumber() + "- " + installmentDTO.getPaymentDate());
            }
        } else
            System.out.println("You Have No Payed Installments");
        this.showMenu();
    }

    private void payInstallments() {
        System.out.println("Payable Amount:");
        InstallmentDTO installmentDTO = installmentService.getPayableInstallment(loanId);
        System.out.println(installmentDTO.getAmount());
        PaymentMenu paymentMenu = new PaymentMenu(loanId, installmentDTO.getId());
        paymentMenu.showMenu();
    }

}

