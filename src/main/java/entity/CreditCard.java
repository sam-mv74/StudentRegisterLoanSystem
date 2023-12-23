package entity;

import base.entity.BaseEntity;
import lombok.*;
import entity.enumeration.Bank;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CreditCard extends BaseEntity<Integer> {
    @Enumerated(EnumType.STRING)
    private Bank bank;
    private String cardNumber;
    private Integer cvv2;
    private LocalDate expirationDate;
    @ManyToOne
    private Student student;
}
