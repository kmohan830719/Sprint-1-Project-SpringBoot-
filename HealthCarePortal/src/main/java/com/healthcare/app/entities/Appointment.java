package com.healthcare.app.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "appointments")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointment_id;

	private Date date;

	@NotEmpty
	@Size(min = 2, message = "name must be of minimum 2 characters!!")
	private String patient_name;

	@NotNull
	@Min(value = 1)
	@Max(value = 120)
	private int patient_age;

	@NotEmpty
	@Size(min = 1, message = "must be minimum of 1 charcter!!")
	private String patient_gender;

	@NotNull
	@Min(value = 1000)
	private int contact_no;

	@NotEmpty
	@Size(min = 5, message = "address must be minimum of 10 characters!!")
	@Column(length = 1000)
	private String address;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Departments department;

	@ManyToOne
	private User user;

}
