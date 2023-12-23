package entity.loan;

import base.entity.BaseEntity;
import lombok.*;
import entity.Installment;
import entity.Student;
import entity.loanCategory.LoanCategory;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Loan extends BaseEntity<Integer> {
    private LocalDate registrationDate;
    @ManyToOne
    private LoanCategory loanCategory;
    @ManyToOne
    private Student student;
    @OneToMany (mappedBy = "loan" , cascade = CascadeType.ALL)
    private List<Installment>installments=new ArrayList<>();
    public void addInstallment(Installment installment){
        installments.add(installment);
        installment.setLoan(this);
    }
}
