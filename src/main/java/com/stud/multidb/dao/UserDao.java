package com.stud.multidb.dao;

import java.util.List;

import com.stud.multidb.model.User;

public interface UserDao {

	public User readUser(int id);

	public List<User> readAllUsers();

	public int createUser(User user);

	public int updateUser(User user);

	public int deleteUser(int id);

}