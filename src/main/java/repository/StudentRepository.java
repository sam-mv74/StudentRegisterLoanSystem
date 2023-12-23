package repository;

import entity.Student;

import java.util.Optional;

public interface StudentRepository extends PersonRepository<Student> {
    Optional<Student> findByUserNameAndPassword(String username, String password);
}
