package repository;

import base.repository.BaseEntityRepository;
import entity.Installment;

import java.util.List;

public interface InstallmentRepository extends BaseEntityRepository<Installment,Integer> {
    List<Installment> findByLoanId(int loanId);
}
