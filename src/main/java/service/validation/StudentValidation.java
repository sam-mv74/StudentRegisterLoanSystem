package service.validation;

import dto.StudentRegistrationDTO;
import entity.enumeration.GradeLevel;
import entity.enumeration.UniversityType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentValidation extends PublicValidation {

    public static List<String> validateStudentRegistrationDTO(StudentRegistrationDTO studentRegistrationDTO) {
        List<String> results = Arrays.asList(gradeValidation(studentRegistrationDTO.getGradeLevel()),
                universityValidation(studentRegistrationDTO.getUniversityType()),
                isNumeric(studentRegistrationDTO.getStudentNumber()),
                isNumeric(studentRegistrationDTO.getYearOfEntry()),
                isYesNo(studentRegistrationDTO.getIsMarried()),
                isYesNo(studentRegistrationDTO.getIsInDorm()),
                birthDateValidation(studentRegistrationDTO.getDateOfBirth()),
                nationalCodeValidation(studentRegistrationDTO.getNationalCode())
        );
        List<String> validationResult = new ArrayList<>();
        for (String result : results) {
            if (!result.isBlank()) {
                validationResult.add(result);
            }
        }
        return validationResult;
    }

    public static String gradeValidation(String gradeLevel) {
        List<GradeLevel> gradeLevels = Arrays.asList(GradeLevel.values());
        String result = "";
        try {
            gradeLevels.contains(GradeLevel.valueOf(gradeLevel.toUpperCase()));
        } catch (IllegalArgumentException e) {
            result = "Invalid GradeLevel";
        }
        return result;
    }

    public static String universityValidation(String universityType) {
        List<UniversityType> universityTypes = Arrays.asList(UniversityType.values());
        String result = "";
        try {
            universityTypes.contains(UniversityType.valueOf(universityType.toUpperCase()));
        } catch (IllegalArgumentException e) {
            result = "Invalid UniversityType";
        }
        return result;
    }


}
