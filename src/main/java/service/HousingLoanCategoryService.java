package service;

import entity.enumeration.CityType;
import entity.loanCategory.HousingLoanCategory;

import java.util.Optional;

public interface HousingLoanCategoryService extends LoanCategoryService<HousingLoanCategory> {
    Optional<HousingLoanCategory> findHousingLoanCategoryByCityType(CityType cityType);
}
