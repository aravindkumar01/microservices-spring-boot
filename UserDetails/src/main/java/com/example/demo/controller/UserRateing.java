package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.modal.Rate;



@Controller
public class UserRateing {
	@RequestMapping(value="/getRating",method=RequestMethod.GET)
	public @ResponseBody List<Rate> get()
	{
		
		try { 

			
			ArrayList<Rate> r=new ArrayList<Rate>();
			
			  
				   for(int i=1;i<=6;i++)
			   {
					   Rate rate=new Rate();
						
				   rate.setId(i);
				   rate.setRate(5);
				   r.add(rate);
			
			   }
			return r;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return null;
	}

	@RequestMapping(value="/getRating/{id}",method=RequestMethod.GET)
	public @ResponseBody Rate rate(@PathVariable("id")long id)
	{
		
		try { 

			
			
					   Rate rate=new Rate();
						
				   rate.setId(id);
				   rate.setRate(5);
				   
			
			 
			return rate;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return null;
	}
}
