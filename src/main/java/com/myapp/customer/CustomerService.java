package com.myapp.customer;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	CustomerDao custDao;
	
	public Customer addCustomerDetails (Customer c) {
		return custDao.addCustomerDetails(c);
	}
	
	public Customer updateName(String name,int id){
		Customer temp=custDao.updateName(name,id);
		temp.setName(name);
		temp.setId(temp.getId());
		temp.setIfscCode(temp.getIfscCode());
		temp.setAccountNumber(temp.getAccountNumber());
		temp.setBranch(temp.getBranch());
		return custDao.updateName(name, id);
	}
	
	
}
