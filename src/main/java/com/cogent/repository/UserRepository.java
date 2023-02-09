package com.cogent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cogent.entity.Author;
import com.cogent.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}