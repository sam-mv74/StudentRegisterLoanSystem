package repository;

import base.repository.BaseEntityRepository;
import entity.Student;
import entity.loan.Loan;

import java.util.List;

public interface LoanRepository<T extends Loan> extends BaseEntityRepository<T,Integer> {
    List<Loan> findByStudent(Student student);
}
