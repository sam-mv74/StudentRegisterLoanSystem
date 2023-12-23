package entity;

import base.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address extends BaseEntity<Integer> {
    @ManyToOne(cascade = CascadeType.ALL)
    private City city;
    private String address;
    private String phoneNumber;
    private Long postalCode;
    @OneToOne(mappedBy = "address")
    private Student student;

    public Address(City city) {
        this.city = city;
    }
}