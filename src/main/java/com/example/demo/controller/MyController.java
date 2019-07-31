package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class MyController {
	
	@Autowired
	private EmployeeRepository repository;

	@RequestMapping(value="/{id}" , method=RequestMethod.GET)
	public Employee getEmployee(@PathVariable Integer id)
	{
		return this.repository.findById(id).get();
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<Employee> getAllEmployees()
	{
		return this.repository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee entity)
	{
		return this.repository.save(entity);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable Integer id)
	{
		Employee entity = this.repository.getOne(id);
		this.repository.delete(entity);
	}

}


