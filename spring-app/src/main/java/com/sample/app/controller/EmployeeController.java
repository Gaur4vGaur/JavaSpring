package com.sample.app.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sample.app.model.Employee;

@RestController
public class EmployeeController {

	@RequestMapping("/")
	public String index() {
		return "This is a spring app";
	}

	@RequestMapping("/employee")
	public Employee sampleEmployee() {
		int randomEmployeeId = (int)(Math.random()*100);
		return new Employee(randomEmployeeId, "sampleEmployee");
	}

	@RequestMapping("/custom-employee")
	public Employee customeEmployee(@RequestParam(value = "name")String name) {
		int randomEmployeeId = (int)(Math.random()*100);
		return new Employee(randomEmployeeId, name);
	}

	@RequestMapping("/custom-employee-id")
	public Employee customeEmployee(@RequestParam(value = "id")int id) {
		return new Employee(id, "sample employee");
	}


}