package com.myapp.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value="/customeradmin")
public class CustomerController {
	@Autowired
	CustomerService custser;
	RestTemplate rest = new RestTemplate();
	@PostMapping(value="/addCustomerDetails")
	public Customer addCustomerDetails(@RequestBody Customer c) {
	
	
		String url="http://localhost:8080/bankadmin/getIfsc/";
		ResponseEntity<String> response=rest.exchange(url+c.getBranch(),HttpMethod.GET,null,String.class);
		String value=response.getBody();
		c.setIfscCode(value);
		return custser.addCustomerDetails(c);
	}
	
	@PutMapping(value="/updateName")
	public Customer updateName(@RequestParam String name,@RequestParam int id) {
		return custser.updateName(name,id);
	}

}
