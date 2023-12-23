package menu;

import java.util.List;
public class RegisterEducationalLoanMenu extends RegisterLoanMenu {
    public void registerEducationalLoan(){
        List<String> results = educationalLoanService.checkQualification();
        if(results.isEmpty()){
            Double loanAmount = educationalLoanService.getLoanAmount();
            showLoanAmount(loanAmount);
            educationalLoanService.registerEducationalLoan();
            System.out.println("Loan Successfully Registered");
        }else {
            System.out.println(results);
        }
        this.showMenu();
    }
}
