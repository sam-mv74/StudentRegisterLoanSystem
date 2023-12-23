package entity;

import base.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person extends BaseEntity<Integer> {
    private String firstName;
    private String lastName;
    private String motherName;
    private String fatherName;
    private String certificateNumber;
    private Long nationalCode;
    private LocalDate dateOfBirth;

    private Boolean isMarried=false;
    @OneToOne(cascade = CascadeType.ALL)
    private Person spouse;
    public Person(String firstName, String lastName, String motherName, String fatherName, String certificateNumber, Long nationalCode, LocalDate dateOfBirth, Boolean isMarried ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.motherName = motherName;
        this.fatherName = fatherName;
        this.certificateNumber = certificateNumber;
        this.nationalCode = nationalCode;
        this.dateOfBirth = dateOfBirth;
        this.isMarried=isMarried;
    }
}
