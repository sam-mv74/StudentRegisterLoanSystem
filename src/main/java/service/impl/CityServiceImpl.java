package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.City;
import repository.CityRepository;
import service.CityService;

import java.util.Optional;

public class CityServiceImpl extends BaseEntityServiceImpl<City, Integer, CityRepository>
        implements CityService {
    public CityServiceImpl(CityRepository repository) {
        super(repository);
    }

    @Override
    public Optional<City> findByName(String cityName) {
        return repository.findByCityName(cityName);
    }
}
