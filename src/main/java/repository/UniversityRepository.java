package repository;

import base.repository.BaseEntityRepository;
import entity.University;

import java.util.Optional;
public interface UniversityRepository extends BaseEntityRepository<University,Integer> {
    Optional<University> findByName(String universityName);
}
