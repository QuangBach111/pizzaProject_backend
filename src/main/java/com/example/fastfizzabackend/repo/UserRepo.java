package com.example.fastfizzabackend.repo;

import com.example.fastfizzabackend.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByPhone(String phone);
}