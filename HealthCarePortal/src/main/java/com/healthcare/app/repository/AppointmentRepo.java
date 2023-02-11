package com.healthcare.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.app.entities.Appointment;
import com.healthcare.app.entities.Departments;
import com.healthcare.app.entities.User;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {

	List<Appointment> findByUser(User user);

	List<Appointment> findByDepartment(Departments depart);
}
