package com.healthcare.app.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.healthcare.app.entities.User;

@Component
public interface UserService {

	User createUser(User user);

	User updateUser(User user, int id);

	User getUserById(int id);

	List<User> getAllUsers();

	void deleteUser(int id);
}
