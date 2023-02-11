package com.healthcare.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.app.entities.Departments;
import com.healthcare.app.exceptions.ResourceNotFoundException;
import com.healthcare.app.repository.DepartmentRepository;
import com.healthcare.app.services.DepartmentService;

@Service
public class DepatmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository dptRepo;

	@Override
	public Departments createDepartment(Departments dpt) {
		Departments dp = this.dptRepo.save(dpt);
		return dp;
	}

	@Override
	public Departments updateDepartment(Departments dpt, int id) {
		Departments dp = this.dptRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Depatrment", "dept_id", id));
		dp.setDep_name(dpt.getDep_name());

		Departments updated = this.dptRepo.save(dp);
		return updated;
	}

	@Override
	public void deleteDepartment(int id) {
		Departments dp = this.dptRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Depatrment", "dept_id", id));
		this.dptRepo.delete(dp);
	}

	@Override
	public Departments getDepartment(int id) {
		Departments dp = this.dptRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Depatrment", "dept_id", id));
		return dp;
	}

	@Override
	public List<Departments> getAllDepartments() {
		List<Departments> list = this.dptRepo.findAll();
		return list;
	}

}
