package com.myapp.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.myapp.models.mongo.Bike;
import com.myapp.repositories.BikeMongoRepository;

@RestController
@RequestMapping("/api/v1/mongo/bike")
public class BikeMongoController {

	@Autowired
	BikeMongoRepository bikeMongoRepository;

	@PostMapping("/create")
	public void create(@RequestBody Bike bike) {
		System.out.println("\n------> "+bike);
		bikeMongoRepository.save(bike);
	}

	@PostMapping("/createAll")
	public void createAll(@RequestBody List<Bike> bikeList) {
		System.out.println("\n------------> ");
		bikeList.forEach(System.out::println);
		bikeMongoRepository.saveAll(bikeList);
	}

}
