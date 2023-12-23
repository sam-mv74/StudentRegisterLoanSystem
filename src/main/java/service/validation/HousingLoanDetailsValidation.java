package service.validation;

import dto.HousingLoanRegistrationDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HousingLoanDetailsValidation extends PublicValidation {
    public static List<String> validateHousingLoanDetails(HousingLoanRegistrationDTO housingLoanRegistrationDTO) {
        List<String> results = List.of(nationalCodeValidation(housingLoanRegistrationDTO.getSpouseNationalCode()),
                isNumeric(housingLoanRegistrationDTO.getPhoneNumber()));
        List<String> validationResult = new ArrayList<>();
        for (String result : results) {
            if (!result.isBlank()) {
                validationResult.add(result);
            }
        }
        return validationResult;
    }
}
