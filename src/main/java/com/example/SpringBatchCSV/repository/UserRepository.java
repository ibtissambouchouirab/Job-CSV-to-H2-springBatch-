package com.example.SpringBatchCSV.repository;

import com.example.SpringBatchCSV.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {}
