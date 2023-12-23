package service;

import base.service.BaseEntityService;
import entity.City;

import java.util.Optional;

public interface CityService extends BaseEntityService<City, Integer> {
    Optional<City> findByName(String cityName);
}
