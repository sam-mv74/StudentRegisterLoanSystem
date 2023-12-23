package service;

import base.service.BaseEntityService;
import dto.InstallmentDTO;
import entity.Installment;

import java.util.List;

public interface InstallmentService extends BaseEntityService<Installment, Integer> {

    List<InstallmentDTO> payedInstallments(int loanId);

    List<InstallmentDTO> unPayedInstallments(int loanId);

    InstallmentDTO getPayableInstallment(int loanId);

    void updateById(int installmentId);
}
