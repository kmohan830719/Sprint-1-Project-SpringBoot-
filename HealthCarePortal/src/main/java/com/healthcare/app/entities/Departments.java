package com.healthcare.app.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Departments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dep_id;

	private String dep_name;

	@OneToMany
	private List<Appointment> appointment = new ArrayList<>();

}
