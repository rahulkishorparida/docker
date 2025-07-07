package com.jc.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jc.demo.model.Car;
import com.jc.demo.service.CarService;
@RestController
@RequestMapping("/docker")
public class CarController {
	
    @Autowired
    private CarService carService;

    
    @GetMapping("/test")
	public String startdocker() {
		return "start";
	}
    // CREATE
    @PostMapping("/add")
    public ResponseEntity<Car> saveCar(@RequestBody Car car) {
        Car savedCar = carService.save(car);
        return ResponseEntity.ok(savedCar);
    }

    // READ ALL
    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carService.findAll());
    }

    // READ BY ID
    @GetMapping("/car/{id}")
    public ResponseEntity<?> getCarById(@PathVariable int id) {
        Optional<Car> car = carService.findyById(id);
        return car.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/car/{id}")
    public ResponseEntity<?> updateCar(@PathVariable int id, @RequestBody Car car) {
        Optional<Car> existingCar = carService.findyById(id);
        if (existingCar.isPresent()) {
            carService.update(id, car);
            return ResponseEntity.ok("Car updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @DeleteMapping("/car/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable int id) {
        if (carService.deleteById(id)) {
            return ResponseEntity.ok("Car deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Car not found.");
        }
    }
    @DeleteMapping("/delete-all")
    public void deleteAllCars() {
        carService.deleteteall(); // make sure your service method name matches
    }

}
