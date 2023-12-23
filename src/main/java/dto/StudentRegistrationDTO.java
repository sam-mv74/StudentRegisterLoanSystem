package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentRegistrationDTO {
    private String firstName;
    private String lastName;
    private String motherName;
    private String fatherName;
    private String certificateNumber;
    private String nationalCode;
    private String dateOfBirth;
    private String city;
    private String isMarried;
    private String studentNumber;
    private String universityName;
    private String universityType;
    private String yearOfEntry;
    private String gradeLevel;
    private String isInDorm;
}
