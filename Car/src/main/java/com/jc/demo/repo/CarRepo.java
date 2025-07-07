package com.jc.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jc.demo.model.Car;

public interface CarRepo extends JpaRepository<Car, Integer> {

}
