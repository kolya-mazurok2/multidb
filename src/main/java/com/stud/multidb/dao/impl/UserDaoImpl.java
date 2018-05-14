package com.stud.multidb.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.stud.multidb.model.User;
import com.stud.multidb.model.mapper.UserRowMapper;
import com.stud.multidb.dao.UserDao;

@Repository
@Qualifier("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int createUser(User user) {
		String sql = "INSERT INTO user"
				+ "(id, login, first_name, last_name, email, password)"
				+ "VALUES(?,?,?,?,?,?)";
		
		int resp = jdbcTemplate.update(sql, new Object[] {
				user.getId(),
				user.getLogin(),
				user.getFirstName(), 
				user.getLastName(),
				user.getEmail(), 
				user.getPassword(), 
				 });
		
		return resp;
	}
        
	public User readUser(int id) {
    	String sql = "SELECT * FROM user WHERE id = ?";
		User user = (User) jdbcTemplate.queryForObject(sql, new Object[] { id }, new UserRowMapper());
		
		return user;
	}

	public List<User> readAllUsers() {
		String sql = "SELECT * FROM user";
    	List<User> user = (List<User>) jdbcTemplate.query(sql, new UserRowMapper());
		
		return user;
	}

	public int updateUser(User user) {
		String sql = "UPDATE user "
				+ "SET "
				+ "login = ?, "
				+ "first_name = ?, "
				+ "last_name = ?, "
				+ "email = ?, "
				+ "password = ? "
				+ "WHERE id = ?";
		
		int resp = jdbcTemplate.update(sql, new Object[] {
				user.getLogin(),
				user.getFirstName(), 
				user.getLastName(),
				user.getEmail(), 
				user.getPassword(),
				user.getId()
		});
		
		return resp;
	}

	public int deleteUser(int id) {
		String sql = "DELETE FROM user WHERE id = ?";
		int resp = jdbcTemplate.update(sql, id);
		
		return resp;
	}
}