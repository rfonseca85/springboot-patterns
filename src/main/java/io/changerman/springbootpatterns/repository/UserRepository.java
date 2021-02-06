package io.changerman.springbootpatterns.repository;

import io.changerman.springbootpatterns.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByLastName(String lastName);
    User findById(long id);
}
