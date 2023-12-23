package menu;

import java.util.List;
public class RegisterTuitionLoanMenu extends RegisterLoanMenu {
    public void registerTuitionLoan(){
        List<String> results = tuitionLoanService.checkQualification();
        if(results.isEmpty()){
            Double loanAmount = tuitionLoanService.getLoanAmount();
            showLoanAmount(loanAmount);
            tuitionLoanService.registerTuitionLoan();
            System.out.println("Loan Successfully Registered");
        }else {
            System.out.println(results);
        }
        this.showMenu();
    }
}
