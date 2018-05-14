package com.stud.multidb.dao;

import java.util.List;

import com.stud.multidb.model.Customer;

public interface CustomerDao {

	public Customer readCustomer(int id);

	public List<Customer> readAllCustomers();

	public int createCustomer(Customer customer);

	public int updateCustomer(Customer customer);

	public int deleteCustomer(int id);

}