package com.myapp.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;

import com.myapp.models.mongo.Bike;
import com.myapp.repositories.BikeMongoRepository;

@RestController
@RequestMapping("/api/v1/mongo/bike")
public class BikeMongoController {

	@Autowired
	BikeMongoRepository bikeMongoRepository;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Bike bike) {
		bikeMongoRepository.insert(bike);
	}

	@PostMapping("/createAll")
	@ResponseStatus(HttpStatus.OK)
	public void createAll(@RequestBody List<Bike> bikeList) {
		bikeList.forEach(System.out::println);
		bikeMongoRepository.insert(bikeList);
	}

	@GetMapping("/all")
	public List<Bike> bikes() {
		return bikeMongoRepository.findAll();
	}

	//http://localhost:8080/api/v1/mongo/bike/email/samantha@bikes.com
	@GetMapping("/email/{email}")
	public Bike bikeByEmail(@PathVariable("email") String email) {
		return bikeMongoRepository.findByEmail(email);
	}

	//sample request - http://localhost:8080/api/v1/mongo/bike/name/Samantha%20Davis
	@GetMapping("/name/{name}")
	public List<Bike> bikesByName(@PathVariable("name") String name) {
		return bikeMongoRepository.findByName(name);
	}

	@PutMapping("/email/{email}")
	@ResponseStatus(HttpStatus.OK)
	public void bikeByEmail(@PathVariable("email") String email, @RequestBody Bike bike) {
		Bike bikeDb = bikeMongoRepository.findByEmail(email);
		bike.setId(bikeDb.getId());
		bikeMongoRepository.save(bike);
	}

	@DeleteMapping("/email/{email}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("email") String email) {
		bikeMongoRepository.delete(bikeMongoRepository.findByEmail(email));
	}

}
