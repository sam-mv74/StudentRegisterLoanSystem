package entity.loanCategory;

import base.entity.BaseEntity;
import lombok.*;
import entity.enumeration.GradeLevel;
import entity.loan.Loan;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class LoanCategory extends BaseEntity<Integer> {
    private Double amount;
    @Enumerated(EnumType.STRING)
    private GradeLevel gradeLevel;
    @OneToMany(mappedBy = "loanCategory")
    private List<Loan> loans;
}
