package repository;

import base.repository.BaseEntityRepository;
import entity.City;

import java.util.Optional;

public interface CityRepository extends BaseEntityRepository<City,Integer> {
    Optional<City> findByCityName(String cityName);
}
