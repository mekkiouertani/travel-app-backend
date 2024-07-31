package com.example.travelapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.travelapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}