package com.jc.demo.service;

import java.util.List;
import java.util.Optional;

import com.jc.demo.model.Car;

public interface CarService {
	
	Car save(Car car);
	boolean deleteById(int id);
    Optional<Car> findyById(int id);
    List<Car> findAll();
    void update(int id, Car car);
    void deleteteall();

}
