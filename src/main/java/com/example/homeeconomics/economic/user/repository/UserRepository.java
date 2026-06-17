package com.example.homeeconomics.economic.user.repository;

import com.example.homeeconomics.economic.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> { }
