package service.validation;

import dto.CreditCardDTO;
import entity.enumeration.Bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardValidation {
    public static List<String> validateCardDTO(CreditCardDTO creditCardDTO) {
        List<String> results = Arrays.asList(validateBank(creditCardDTO.getBank()),
                validateCardNumber(creditCardDTO.getCardNumber()),
                validateCvv2(creditCardDTO.getCvv2()),
                validateExpirationDate(creditCardDTO.getExpirationDate())
        );
        List<String> validationResult = new ArrayList<>();
        for (String result : results) {
            if (!result.isBlank()) {
                validationResult.add(result);
            }
        }
        return validationResult;
    }

    public static String validateBank(String bank) {
        List<Bank> banks = Arrays.asList(Bank.values());
        String result = "";
        try {
            banks.contains(Bank.valueOf(bank.toUpperCase()));
        } catch (IllegalArgumentException e) {
            result = "Invalid GradeLevel";
        }
        return result;
    }

    public static String validateCardNumber(String creditCardNumber) {
        String regex = "^(\\d{4}-){3}\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(creditCardNumber);
        if (!matcher.matches()) {
            return "Invalid Card Number Format";
        }
        return "";
    }

    public static String validateCvv2(String input) {
        Pattern pattern = Pattern.compile("\\d{4}");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            return "Invalid Cvv2 Format";
        }
        return "";
    }

    public static String validateExpirationDate(String expireDate) {
        String result = "";
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(expireDate, formatter);
        } catch (Exception e) {
            result = "Invalid Date Format";
        }
        return result;
    }
}
