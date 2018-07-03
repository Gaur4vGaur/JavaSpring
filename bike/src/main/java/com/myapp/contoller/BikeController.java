package com.myapp.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.ArrayList;

import com.myapp.models.Bike;


@RestController
@RequestMapping("api/v1/bike")
public class BikeController {

	@GetMapping
	public List<Bike> list() {
		List<Bike> bikes = new ArrayList<>();
		return bikes;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Bike bike) {

	}

	@GetMapping("/{id}")
	public Bike get(@PathVariable("id") long id) {
		return new Bike();
	}

}