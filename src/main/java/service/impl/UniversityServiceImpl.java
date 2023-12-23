package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.University;
import repository.UniversityRepository;
import service.UniversityService;

import java.util.Optional;

public class UniversityServiceImpl extends BaseEntityServiceImpl<University, Integer, UniversityRepository>
        implements UniversityService {
    public UniversityServiceImpl(UniversityRepository repository) {
        super(repository);
    }

    @Override
    public Optional<University> findByName(String universityName) {
        return repository.findByName(universityName);
    }
}
