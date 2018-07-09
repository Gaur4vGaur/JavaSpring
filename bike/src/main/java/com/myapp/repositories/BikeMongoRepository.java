package com.myapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.myapp.models.mongo.Bike;

public interface BikeMongoRepository extends MongoRepository<Bike, Long> {

}
