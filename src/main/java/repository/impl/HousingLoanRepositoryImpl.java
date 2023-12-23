package repository.impl;

import entity.enumeration.GradeLevel;
import entity.loan.HousingLoan;
import repository.HousingLoanRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class HousingLoanRepositoryImpl extends LoanRepositoryImpl<HousingLoan> implements HousingLoanRepository {
    public HousingLoanRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<HousingLoan> getEntityClass() {
        return HousingLoan.class;
    }

    @Override
    public Boolean existByStudentNationalCodeAndGrade(Long nationalCode, GradeLevel gradeLevel) {
        try {
            String hql = "select count(h) from HousingLoan h where h.student.nationalCode= :nationalCode and h.student.gradeLevel= :gradeLevel";
            TypedQuery<Long> query = entityManager.createQuery(hql, Long.class);
            query.setParameter("nationalCode", nationalCode);
            query.setParameter("gradeLevel", gradeLevel);
            return query.getSingleResult() > 0;
        } catch (Exception e) {
            return false;
        }

    }
}
