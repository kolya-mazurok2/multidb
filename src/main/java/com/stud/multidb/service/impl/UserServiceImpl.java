package com.stud.multidb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stud.multidb.model.User;
import com.stud.multidb.dao.UserDao;
import com.stud.multidb.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public int createUser(User user) {
		return userDao.createUser(user);
	}
	
	public User readUser(int id) {
		return userDao.readUser(id);
	}

	public List<User> readAllUsers() {
		return userDao.readAllUsers();
	}

	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	public int deleteUser(int id) {
		return userDao.deleteUser(id);
	}

	public UserDao readUserDao() {
		return userDao;
	}

}