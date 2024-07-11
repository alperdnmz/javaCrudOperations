package dev.alperdonmez.javaCrudOperations.repository;

import dev.alperdonmez.javaCrudOperations.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
