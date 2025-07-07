package com.jc.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jc.demo.model.Car;
import com.jc.demo.repo.CarRepo;
import com.jc.demo.service.CarService;
@Service
public class CarServiceImpl implements CarService {
	@Autowired
	private CarRepo carRepo;

	@Override
	public Car save(Car car) {
		Car save = carRepo.save(car);
		return save;
	}
	

	@Override
	public boolean deleteById(int id) {
		if(carRepo.existsById(id))
			carRepo.deleteById(id);
		return true;
	}

	@Override
	public Optional<Car> findyById(int id) {
		Optional<Car> byId = carRepo.findById(id);
		return byId;
	}

	@Override
	public List<Car> findAll() {
		List<Car> all = carRepo.findAll();
		return all;
	}

	@Override
	public void update( int id,Car car) {
		Optional<Car> byId = carRepo.findById(id);
		if(byId.isPresent()) {
			Car c = byId.get();
		c.setName(car.getName());
		c.setCountCar(car.getCountCar());
		
		carRepo.save(c);
		}
		
		
	}

	@Override
	public void deleteteall() {
	    carRepo.deleteAll();
	}

}
