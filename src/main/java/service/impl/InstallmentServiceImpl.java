package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import dto.InstallmentDTO;
import entity.Installment;
import repository.InstallmentRepository;
import service.InstallmentService;
import utility.SecurityContext;

import java.util.*;

public class InstallmentServiceImpl extends BaseEntityServiceImpl<Installment, Integer, InstallmentRepository>
        implements InstallmentService {
    public InstallmentServiceImpl(InstallmentRepository repository) {
        super(repository);
    }

    @Override
    public List<InstallmentDTO> payedInstallments(int loanId) {
        List<Installment> installments = repository.findByLoanId(loanId);
        List<InstallmentDTO> payedInstallments = new ArrayList<>();
        if (!installments.isEmpty()) {
            for (Installment installment : installments) {
                if (installment.getIsPayed()) {
                    InstallmentDTO installmentDTO = new InstallmentDTO();
                    installmentDTO.setNumber(installment.getNumber());
                    installmentDTO.setPaymentDate(installment.getPaymentDate());
                    payedInstallments.add(installmentDTO);
                }
            }
        }
        return payedInstallments;
    }

    @Override
    public List<InstallmentDTO> unPayedInstallments(int loanId) {
        List<Installment> installments = repository.findByLoanId(loanId);
        List<InstallmentDTO> unPayedInstallments = new ArrayList<>();
        if (!installments.isEmpty()) {
            for (Installment installment : installments) {
                if (!installment.getIsPayed()) {
                    InstallmentDTO installmentDTO = new InstallmentDTO();
                    installmentDTO.setNumber(installment.getNumber());
                    installmentDTO.setDueDate(installment.getDueDate());
                    installmentDTO.setAmount(installment.getAmount());
                    unPayedInstallments.add(installmentDTO);
                }
            }
        }
        return unPayedInstallments;
    }

    @Override
    public InstallmentDTO getPayableInstallment(int loanId) {
        List<Installment> installments = repository.findByLoanId(loanId);
        List<Installment> filteredAndSortedInstallments = installments.stream()
                .filter(installment -> !installment.getIsPayed())
                .sorted(Comparator.comparing(Installment::getDueDate)).toList();
        Installment payableInstallment = filteredAndSortedInstallments.get(0);
        InstallmentDTO installmentDTO = new InstallmentDTO();
        installmentDTO.setId(payableInstallment.getId());
        installmentDTO.setAmount(payableInstallment.getAmount());
        return installmentDTO;
    }

    @Override
    public void updateById(int installmentId) {
        Optional<Installment> optional = repository.findById(installmentId);
        Installment installment = optional.orElse(null);
        assert installment != null;
        installment.setIsPayed(true);
        installment.setPaymentDate(SecurityContext.getCurrentDate());
        repository.saveOrUpdate(installment);
    }
}
