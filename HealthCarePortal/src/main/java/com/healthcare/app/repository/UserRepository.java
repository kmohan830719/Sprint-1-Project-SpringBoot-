package com.healthcare.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.app.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
