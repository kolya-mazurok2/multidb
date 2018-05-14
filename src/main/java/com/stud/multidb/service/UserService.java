package com.stud.multidb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stud.multidb.model.User;

@Service
public interface UserService {
	
	public int createUser(User user);

	public User readUser(int id);

	public List<User> readAllUsers();	

	public int updateUser(User user);

	public int deleteUser(int id);
}