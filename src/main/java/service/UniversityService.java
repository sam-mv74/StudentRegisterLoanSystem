package service;

import base.service.BaseEntityService;
import entity.University;

import java.util.Optional;

public interface UniversityService extends BaseEntityService<University, Integer> {
    Optional<University> findByName(String universityName);
}
