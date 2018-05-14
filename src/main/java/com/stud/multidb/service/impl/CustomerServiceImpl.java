package com.stud.multidb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stud.multidb.model.Customer;
import com.stud.multidb.dao.CustomerDao;
import com.stud.multidb.service.CustomerService;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	public int createCustomer(Customer customer) {
		return customerDao.createCustomer(customer);
	}
	
	public Customer readCustomer(int id) {
		return customerDao.readCustomer(id);
	}

	public List<Customer> readAllCustomers() {
		return customerDao.readAllCustomers();
	}

	public int updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}

	public int deleteCustomer(int id) {
		return customerDao.deleteCustomer(id);
	}

	public CustomerDao readCustomerDao() {
		return customerDao;
	}

}