package entity;

import lombok.*;
import entity.enumeration.GradeLevel;
import entity.loan.Loan;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student extends Person {
    private Long studentNumber;
    private String username;
    private String password;
    @ManyToOne(cascade = CascadeType.ALL)
    private University university;
    private Integer yearOfEntry;
    @Enumerated(EnumType.STRING)
    private GradeLevel gradeLevel;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @Column(columnDefinition = "Boolean default false")
    private Boolean isInDorm;
    @OneToMany(mappedBy = "student")
    private List<CreditCard> creditCards;
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<Loan> loans;
    public Student(String firstName, String lastName, String motherName, String fatherName,
                   String certificateNumber, Long nationalCode, LocalDate dateOfBirth, Address address, Boolean isMarried,
                   Long studentNumber, University university, Integer yearOfEntry,
                   GradeLevel gradeLevel, Boolean isInDorm) {
        super(firstName, lastName, motherName, fatherName, certificateNumber, nationalCode, dateOfBirth,isMarried);
        this.studentNumber = studentNumber;
        this.university = university;
        this.yearOfEntry = yearOfEntry;
        this.gradeLevel = gradeLevel;
        this.address=address;
        this.isInDorm = isInDorm;
    }
}
