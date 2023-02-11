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

import com.healthcare.app.entities.Appointment;
import com.healthcare.app.services.AppointmentService;
import com.healthcare.app.util.AppResponse;

@RestController
@RequestMapping("/appointment")
public class AppointmentCotroller {

	@Autowired
	private AppointmentService aptSer;

	// post appointment
	@PostMapping("/user/{userId}/department/{depId}")
	public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment apt, @PathVariable int userId,
			@PathVariable int depId) {
		Appointment at = this.aptSer.createAppointment(apt, userId, depId);
		return new ResponseEntity<Appointment>(at, HttpStatus.CREATED);
	}

	// update appointment
	@PutMapping("/{id}")
	public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment apt, @PathVariable int id) {
		Appointment ap = this.aptSer.updateAppointment(apt, id);
		return new ResponseEntity<Appointment>(ap, HttpStatus.OK);
	}

	// delete appointment
	@DeleteMapping("/{id}")
	public ResponseEntity<AppResponse> deleteAppointment(@PathVariable int id) {
		this.aptSer.deleteAppointment(id);
		return new ResponseEntity<AppResponse>(new AppResponse("Appointment is deleted sucessfully", true),
				HttpStatus.OK);
	}

	// get appointment by id
	@GetMapping("/{id}")
	public ResponseEntity<Appointment> getAppointmnetById(@PathVariable int id) {
		Appointment ap = this.aptSer.getAppointmentById(id);
		return new ResponseEntity<Appointment>(ap, HttpStatus.OK);
	}

	// get all appointments
	@GetMapping("/")
	public ResponseEntity<List<Appointment>> getAllAppointments() {
		List<Appointment> list = this.aptSer.getAllAppintments();
		return new ResponseEntity<List<Appointment>>(list, HttpStatus.OK);
	}
}
