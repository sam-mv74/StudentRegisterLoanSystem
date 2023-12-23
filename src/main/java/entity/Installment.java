package entity;

import base.entity.BaseEntity;
import lombok.*;
import entity.loan.Loan;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Installment extends BaseEntity<Integer> {
    private Integer number;
    private Double amount;
    private Boolean isPayed=false;
    private LocalDate dueDate;
    private LocalDate paymentDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private Loan loan;
}
