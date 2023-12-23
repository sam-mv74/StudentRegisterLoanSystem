package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.Person;
import repository.PersonRepository;

import javax.persistence.EntityManager;

public class PersonRepositoryImpl<T extends Person> extends BaseEntityRepositoryImpl<T, Integer> implements PersonRepository<T> {
    public PersonRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<T> getEntityClass() {
        return null;
    }
}
