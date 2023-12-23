package service.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PublicValidation {
    protected static String isNumeric(String input) {
        if (!input.matches("\\d+")) {
            return "Entry Year and NationalCode Must be Numeric";
        }
        return "";
    }

    protected static String isYesNo(String input) {
        if (!(input.equals("y") || input.equals("n"))) {
            return "Invalid Input For y/n Questions";
        }
        return "";
    }

    protected static String birthDateValidation(String birthDate) {
        String result = "";
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate.parse(birthDate, formatter);
        } catch (Exception e) {
            result = "Invalid Date Format";
        }
        return result;
    }

    protected static String nationalCodeValidation(String nationalCode) {
        if (!(nationalCode.matches("[0-9]{10}") && isChecksumValid(nationalCode))) {
            return "Invalid National Code";
        }
        return "";
    }

    protected static boolean isChecksumValid(String nationalCode) {
        int[] digit = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (nationalCode.charAt(i) - '0') * digit[i];
        }
        int remainder = sum % 11;
        int calculatedChecksum = (remainder < 2) ? remainder : 11 - remainder;
        return (calculatedChecksum == nationalCode.charAt(9) - '0');
    }
}
