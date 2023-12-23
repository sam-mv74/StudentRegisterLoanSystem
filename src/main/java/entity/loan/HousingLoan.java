package entity.loan;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class HousingLoan extends Loan {
    private Long rentalNumber;
}
