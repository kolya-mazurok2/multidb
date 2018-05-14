package com.stud.multidb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stud.multidb.model.Customer;

@Service
public interface CustomerService {
	
	public int createCustomer(Customer customer);

	public Customer readCustomer(int id);

	public List<Customer> readAllCustomers();	

	public int updateCustomer(Customer customer);

	public int deleteCustomer(int id);
}