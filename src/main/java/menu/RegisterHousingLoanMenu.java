package menu;

import dto.HousingLoanRegistrationDTO;

import java.util.List;

public class RegisterHousingLoanMenu extends RegisterLoanMenu {
    public void registerHousingLoan() {
        HousingLoanRegistrationDTO housingLoanDTO = getExtraHousingLoanDetails();
        List<String> addResult = housingLoanService.addStudentHousingLoanDetails(housingLoanDTO);
        if (addResult.isEmpty()) {
            List<String> results = housingLoanService.checkQualification();
            if (results.isEmpty()) {
                Double loanAmount = housingLoanService.getLoanAmount();
                showLoanAmount(loanAmount);
                housingLoanService.registerHousingLoan(housingLoanDTO);
                System.out.println("Loan Successfully Granted To You");
            } else {
                System.out.println(results);
            }
        } else {
            System.out.println(addResult);
        }
        this.showMenu();
    }

    private HousingLoanRegistrationDTO getExtraHousingLoanDetails() {
        System.out.println("--Spouse Details--");
        System.out.println("Spouse firstName:");
        String spouseFirstName = scanner.next();
        System.out.println("Spouse lastName:");
        String spouseLastName = scanner.next();
        System.out.println("Spouse nationalCode:");
        String spouseNationalCode = scanner.next();
        System.out.println("--Address Details--");
        System.out.println("Full Address:");
        String address = scanner.next();
        System.out.println("PostalCode:");
        String postalCode = scanner.next();
        System.out.println("Phone Number:");
        String phoneNumber = scanner.next();
        System.out.println("House RentalNumber:");
        Long rentalNumber = scanner.nextLong();
        return new HousingLoanRegistrationDTO(spouseFirstName, spouseLastName,
                spouseNationalCode, address, postalCode, phoneNumber, rentalNumber);
    }
}
