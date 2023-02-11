package com.healthcare.app.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.app.entities.Appointment;
import com.healthcare.app.entities.Departments;
import com.healthcare.app.entities.User;
import com.healthcare.app.exceptions.ResourceNotFoundException;
import com.healthcare.app.repository.AppointmentRepo;
import com.healthcare.app.repository.DepartmentRepository;
import com.healthcare.app.repository.UserRepository;
import com.healthcare.app.services.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepo appRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private DepartmentRepository deptRepo;

	// create appointment
	@Override
	public Appointment createAppointment(Appointment apt, int userId, int depId) {

		User ur = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));

		Departments dpt = this.deptRepo.findById(depId)
				.orElseThrow(() -> new ResourceNotFoundException("Department", "DepartmentId", depId));

		Appointment ap = this.appRepo.save(apt);
		ap.setUser(ur);
		ap.setDepartment(dpt);
		ap.setDate(new Date());

		Appointment ap2 = this.appRepo.save(ap);

		return ap2;

	}

	// update appointment
	@Override
	public Appointment updateAppointment(Appointment apt, int id) {
		Appointment ap = this.appRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Appointment", "Appoi_id", id));
		ap.setPatient_name(apt.getPatient_name());
		ap.setPatient_age(apt.getPatient_age());
		ap.setPatient_gender(apt.getPatient_gender());
		ap.setAddress(apt.getAddress());
		ap.setContact_no(apt.getContact_no());
		return ap;
	}

	// delete appointment
	@Override
	public void deleteAppointment(int id) {
		Appointment ap = this.appRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("appointment", "apt_id", id));
		this.appRepo.delete(ap);
	}

	// get appointment by id
	@Override
	public Appointment getAppointmentById(int id) {
		Appointment ap = this.appRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("appointment", "appoin_id", id));
		return ap;
	}

	// get all appointments
	@Override
	public List<Appointment> getAllAppintments() {
		List<Appointment> list = this.appRepo.findAll();
		return list;
	}

}
