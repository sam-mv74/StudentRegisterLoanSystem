package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.City;
import repository.CityRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class CityRepositoryImpl extends BaseEntityRepositoryImpl<City, Integer> implements CityRepository {
    public CityRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<City> getEntityClass() {
        return City.class;
    }

    @Override
    public Optional<City> findByCityName(String cityName) {
        try {
            String hql = "select c from City c where name = :cityName";
            TypedQuery<City> query = entityManager.createQuery(hql, City.class);
            query.setParameter("cityName", cityName);
            return Optional.of(query.getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
