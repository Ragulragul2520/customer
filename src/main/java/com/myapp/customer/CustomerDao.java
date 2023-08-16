package com.myapp.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
	@Autowired
	CustomerRepository custRepo;
	
	public Customer addCustomerDetails(Customer c) {
		return custRepo.save(c);
	}
	
	public Customer updateName(String name,int id) {
	 return custRepo.findById(id).get();
		
	}
	
	
}
