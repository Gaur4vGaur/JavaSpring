package com.myapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import com.myapp.models.mongo.Bike;


public interface BikeMongoRepository extends MongoRepository<Bike, String> {

	public Bike findByEmail(String email);
    public List<Bike> findByName(String name);

}
