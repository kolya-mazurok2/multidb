package com.stud.multidb.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.stud.multidb.model.User;

public class UserRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int row) throws SQLException {
		User user = new User();
		
		user.setId(rs.getInt("id"));
		user.setLogin(rs.getString("login"));
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		
		return user;
	}

}