package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.enumeration.GradeLevel;
import entity.loanCategory.LoanCategory;
import repository.LoanCategoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Optional;

public abstract class LoanCategoryRepositoryImpl <T extends LoanCategory> extends BaseEntityRepositoryImpl<T,Integer> implements LoanCategoryRepository<T> {
    public LoanCategoryRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }
    @Override
    public Optional<LoanCategory> findLoanCategoryByGradeLevel(GradeLevel gradeLevel){
        try {
            String hql = "select l from "+getEntityClass().getSimpleName()+" l where l.gradeLevel = :gradeLevel";
            TypedQuery<T> query = entityManager.createQuery(hql, getEntityClass());
            query.setParameter("gradeLevel",gradeLevel);
            return Optional.of(query.getSingleResult());
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
