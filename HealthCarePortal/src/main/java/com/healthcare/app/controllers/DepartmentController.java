package com.healthcare.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.app.entities.Departments;
import com.healthcare.app.services.DepartmentService;
import com.healthcare.app.util.AppResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService deptSer;

	// create
	@PostMapping("/")
	public ResponseEntity<Departments> createDepartment(@Valid @RequestBody Departments dpt) {
		Departments created = this.deptSer.createDepartment(dpt);
		return new ResponseEntity<Departments>(created, HttpStatus.CREATED);
	}

	// update
	@PutMapping("/{id}")
	public ResponseEntity<Departments> updateDepartment(@Valid @RequestBody Departments dpt, @PathVariable int id) {
		Departments updated = this.deptSer.updateDepartment(dpt, id);
		return new ResponseEntity<Departments>(updated, HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/{id}")
	public ResponseEntity<AppResponse> deleteDepartment(@PathVariable int id) {
		this.deptSer.deleteDepartment(id);
		return new ResponseEntity<AppResponse>(new AppResponse("Department is deleted succsesfilly", true),
				HttpStatus.OK);
	}

	// get
	@GetMapping("/{id}")
	public ResponseEntity<Departments> getById(@PathVariable int id) {
		Departments dp = this.deptSer.getDepartment(id);
		return new ResponseEntity<Departments>(dp, HttpStatus.OK);
	}

	// getAll
	@GetMapping("/")
	public ResponseEntity<List<Departments>> getAllDepartments() {
		List<Departments> list = this.deptSer.getAllDepartments();
		return new ResponseEntity<List<Departments>>(list, HttpStatus.OK);
	}

}
