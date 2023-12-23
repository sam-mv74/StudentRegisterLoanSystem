package service.impl;

import entity.enumeration.CityType;
import entity.loanCategory.HousingLoanCategory;
import repository.HousingLoanCategoryRepository;
import service.HousingLoanCategoryService;

import java.util.Optional;

public class HousingLoanCategoryServiceImpl extends LoanCategoryServiceImpl<HousingLoanCategory, HousingLoanCategoryRepository> implements HousingLoanCategoryService {
    public HousingLoanCategoryServiceImpl(HousingLoanCategoryRepository repository) {
        super(repository);
    }

    @Override
    public Optional<HousingLoanCategory> findHousingLoanCategoryByCityType(CityType cityType) {
        return repository.findLoanCategoryByCityType(cityType);
    }
}
