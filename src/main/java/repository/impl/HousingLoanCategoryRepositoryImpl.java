package repository.impl;

import entity.enumeration.CityType;
import entity.loanCategory.HousingLoanCategory;
import repository.HousingLoanCategoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class HousingLoanCategoryRepositoryImpl extends LoanCategoryRepositoryImpl<HousingLoanCategory> implements HousingLoanCategoryRepository {
    public HousingLoanCategoryRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<HousingLoanCategory> getEntityClass() {
        return HousingLoanCategory.class;
    }

    @Override
    public Optional<HousingLoanCategory> findLoanCategoryByCityType(CityType cityType) {
        try {
            String hql = "select h from HousingLoanCategory h where h.cityType = :cityType";
            TypedQuery<HousingLoanCategory> query = entityManager.createQuery(hql, HousingLoanCategory.class);
            query.setParameter("cityType", cityType);
            return Optional.of(query.getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
