package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entity.Customer;
import com.example.demo.Entity.Rate;
import com.example.demo.Repo.CustomerRepo;
import com.example.demo.Service.CustomerService;

@Controller
public class CustomerController {
	
	   @Autowired
	   RestTemplate restTemplate;
	@Autowired
	CustomerRepo repo;
	@Autowired
	CustomerService service;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public @ResponseBody String add(@RequestBody Customer customer)
	{
		
		try {
			String result=service.add(customer);
			return result;
			
		} catch (Exception e) {
			// TODO: handle exception
			return e.toString();
		}
		
	}
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public @ResponseBody List<Customer> get()
	{
		
		try {
			
			return  repo.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return null;
	}


	@RequestMapping(value="/getRate",method=RequestMethod.GET)
	public @ResponseBody List<Rate>  getProductList() {
	   
		ResponseEntity<List<Rate>> response = restTemplate.exchange(
		  "http://user-rate/getRating",
		  HttpMethod.GET,
		  null,
		  new ParameterizedTypeReference<List<Rate>>(){});
		List<Rate>  rate = response.getBody();
        
		return rate;
   }
}
