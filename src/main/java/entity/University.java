package entity;

import base.entity.BaseEntity;
import lombok.*;
import entity.enumeration.UniversityType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class University extends BaseEntity<Integer> {
    private String name;
    @Enumerated(EnumType.STRING)
    private UniversityType universityType;
    @OneToMany(mappedBy = "university")
    private List<Student>students;
    public University(String name, UniversityType universityType) {
        this.name = name;
        this.universityType = universityType;
    }
}
