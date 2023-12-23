package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InstallmentDTO {
    private Integer id;
    private Integer number;
    private Double amount;
    private Boolean isPayed;
    private LocalDate dueDate;
    private LocalDate paymentDate;
}
