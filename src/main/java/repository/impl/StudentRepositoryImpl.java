package repository.impl;

import entity.Student;
import repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class StudentRepositoryImpl extends PersonRepositoryImpl<Student> implements StudentRepository {
    public StudentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }
    @Override
    public Optional<Student> findByUserNameAndPassword(String username, String password) {
        try {
            String sql = "select s from "
                    + getEntityClass().getSimpleName()
                    + " s where s.username = :username And s.password = :password";
            TypedQuery<Student> query = entityManager.createQuery(sql, getEntityClass());
            query.setParameter("username", username);
            query.setParameter("password", password);
            return Optional.of(query.getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }
}
