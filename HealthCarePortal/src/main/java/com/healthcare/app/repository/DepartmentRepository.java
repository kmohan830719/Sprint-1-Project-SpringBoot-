package com.healthcare.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.app.entities.Departments;

public interface DepartmentRepository extends JpaRepository<Departments, Integer> {

}
