package repository;

import base.repository.BaseEntityRepository;
import entity.Person;

public interface PersonRepository<T extends Person> extends BaseEntityRepository<T ,Integer> {
}
