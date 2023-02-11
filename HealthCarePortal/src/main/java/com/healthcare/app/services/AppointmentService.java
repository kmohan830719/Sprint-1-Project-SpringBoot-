package com.healthcare.app.services;

import java.util.List;

import com.healthcare.app.entities.Appointment;

public interface AppointmentService {

	// create
	Appointment createAppointment(Appointment apt, int userId, int depId);

	// update
	Appointment updateAppointment(Appointment apt, int id);

	// delete
	void deleteAppointment(int id);

	// get single Appointment
	Appointment getAppointmentById(int id);

	// get all appointments
	List<Appointment> getAllAppintments();

}
