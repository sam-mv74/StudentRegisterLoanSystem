package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HousingLoanRegistrationDTO {
    String spouseFirstName;
    String spouseLastName;
    String spouseNationalCode;
    String address;
    String postalCode;
    String phoneNumber;
    Long rentalNumber;
}
