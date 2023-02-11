package com.healthcare.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.app.entities.User;
import com.healthcare.app.exceptions.ResourceNotFoundException;
import com.healthcare.app.repository.UserRepository;
import com.healthcare.app.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User createUser(User user) {
		User usr = this.userRepo.save(user);
		return usr;
	}

	@Override
	public User updateUser(User user, int id) {
		User us = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));

		us.setName(user.getName());
		us.setEmail(user.getEmail());
		us.setAge(user.getAge());
		us.setGender(user.getGender());

		User usr = this.userRepo.save(us);
		return usr;
	}

	@Override
	public User getUserById(int id) {
		User usr = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
		return usr;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> usr = this.userRepo.findAll();
		return usr;
	}

	@Override
	public void deleteUser(int id) {

		User usr = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));

		this.userRepo.delete(usr);
	}

}
