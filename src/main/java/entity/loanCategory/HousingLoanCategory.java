package entity.loanCategory;

import entity.enumeration.CityType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HousingLoanCategory extends LoanCategory{
    @Enumerated(EnumType.STRING)
    CityType cityType;
}
