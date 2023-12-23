package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreditCardDTO {
    private String bank;
    private String cardNumber;
    private String cvv2;
    private String expirationDate;
}
