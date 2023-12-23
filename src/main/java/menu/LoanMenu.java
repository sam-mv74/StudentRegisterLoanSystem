package menu;

import dto.CreditCardDTO;

public abstract class LoanMenu extends MainMenu {
    public CreditCardDTO getCreditCardDetails() {
        String bank = getBank();
        System.out.println("Card Number:");
        String cardNumber = scanner.next();
        System.out.println("CVV2:");
        String cvv2 = scanner.next();
        System.out.println("ExpirationDate:(yyyy-MM-dd)");
        String expireDate = scanner.next();
        return new CreditCardDTO(bank, cardNumber, cvv2, expireDate);
    }

    private String getBank() {
        String bank = "";
        boolean flag = true;
        while (flag) {
            System.out.println("""
                    Bank:
                    1.MELLI
                    2.TEJARAT
                    3.REFAH
                    4.MASKAN
                    """);
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> {
                    bank = "MELLI";
                    flag = false;
                }
                case 2 -> {
                    bank = "TEJARAT";
                    flag = false;
                }
                case 3 -> {
                    bank = "REFAH";
                    flag = false;
                }
                case 4 -> {
                    bank = "MASKAN";
                    flag = false;
                }
                default -> System.out.println("Invalid Input");
            }
        }
        return bank;
    }
}
