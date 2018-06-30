package com.sample.app.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.sample.app.model.Employee;

@RestController
@RequestMapping("/app-name")
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

	// by default request mapping is GET
	@RequestMapping("/custom-employee-id")
	public Employee customeEmployee(@RequestParam(value = "id")int id) {
		return new Employee(id, "sample employee");
	}

	@GetMapping("custom-employee/{id}")
	public Employee customeEmployeeId(@PathVariable int id) {
		return new Employee(id, "Sample Employee");
	}

	/**
	 * Post mapping - url - http://localhost:8080/app-name/create-employee/another-input
	 * sample json - {"id":24,"name":"sample employee"}
	 * internal json conversion
	 *
	 **/
	@PostMapping("create-employee/{input}")
	public Employee create(@PathVariable String input, @RequestBody Employee employee) {
		System.out.println("\n"+input+"\n");
		return new Employee(employee.getId(), employee.getName());	
	}

}
