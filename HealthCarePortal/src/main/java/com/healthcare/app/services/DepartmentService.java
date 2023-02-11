package com.healthcare.app.services;

import java.util.List;

import com.healthcare.app.entities.Departments;

public interface DepartmentService {

	Departments createDepartment(Departments dpt);

	Departments updateDepartment(Departments dpt, int id);

	void deleteDepartment(int id);

	Departments getDepartment(int id);

	List<Departments> getAllDepartments();

}
