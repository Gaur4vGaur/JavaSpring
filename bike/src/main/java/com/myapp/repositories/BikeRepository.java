package com.myapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myapp.models.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long> {
	
}
