package com.stud.multidb.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.stud.multidb.model.Customer;
import com.stud.multidb.model.mapper.CustomerRowMapper;
import com.stud.multidb.dao.CustomerDao;

@Repository
@Qualifier("customerDao")
public class CustomerDaoImpl implements CustomerDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("secondDataSource")
	public void init(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int createCustomer(Customer customer) {
		String sql = "INSERT INTO customer"
				+ "(id,first_name,last_name)"
				+ "VALUES(?,?,?)";
		
		int resp = jdbcTemplate.update(sql, new Object[] {
				customer.getId(),
				customer.getFirstName(), 
				customer.getLastName()
		});
		
		return resp;
	}
        
	public Customer readCustomer(int id) {
    	String sql = "SELECT * FROM customer WHERE id = ?";
		Customer customer = (Customer) jdbcTemplate.queryForObject(sql, new Object[] { id }, new CustomerRowMapper());
		
		return customer;
	}

	public List<Customer> readAllCustomers() {
		String sql = "SELECT * FROM customer";
    	List<Customer> customer = (List<Customer>) jdbcTemplate.query(sql, new CustomerRowMapper());
		
		return customer;
	}

	public int updateCustomer(Customer customer) {
		String sql = "UPDATE customer "
				+ "SET "
				+ "first_name = ?, "
				+ "last_name = ? "
				+ "WHERE id = ?";
		
		int resp = jdbcTemplate.update(sql, new Object[] {
				customer.getFirstName(),
				customer.getLastName(),
				customer.getId()
		});
		
		return resp;
	}

	public int deleteCustomer(int id) {
		String sql = "DELETE FROM customer WHERE id = ?";
		int resp = jdbcTemplate.update(sql, id);
		
		return resp;
	}
}