package repository;

import entity.enumeration.CityType;
import entity.loanCategory.HousingLoanCategory;

import java.util.Optional;

public interface HousingLoanCategoryRepository extends LoanCategoryRepository<HousingLoanCategory> {
    Optional<HousingLoanCategory> findLoanCategoryByCityType(CityType cityType);
}
