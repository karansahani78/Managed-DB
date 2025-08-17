package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
public class ManagedDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagedDbApplication.class, args);
    }

    //  Entity
    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Car {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String model;
        private String engine;
    }


    //  Service
    @Service
    public static class CarService {
        private final CarRepository carRepository;

        public CarService(CarRepository carRepository) {
            this.carRepository = carRepository;
        }

        public Car saveCar(Car car) {
            return carRepository.save(car);
        }

        public Car findById(Long id) {
            return carRepository.findById(id).orElse(null);
        }

        public Car findByModel(String model) {
            return carRepository.findByModel(model);
        }

        public List<Car> findAll() {
            return carRepository.findAll();
        }

        public Car updateCar(Long id, Car car) {
            Car existingCar = findById(id);
            if (existingCar == null) {
                return null; // or throw exception
            }
            existingCar.setModel(car.getModel());
            existingCar.setEngine(car.getEngine());
            return carRepository.save(existingCar);
        }

        public void deleteById(Long id) {
            carRepository.deleteById(id);
        }
    }

    //  Controller
    @RestController
    @RequestMapping("/api/v1/car")
    public static class CarController {
        private final CarService carService;

        public CarController(CarService carService) {
            this.carService = carService;
        }

        @PostMapping("/save")
        public ResponseEntity<Car> save(@RequestBody Car car) {
            return ResponseEntity.status(HttpStatus.CREATED).body(carService.saveCar(car));
        }

        @GetMapping("/id/{id}")
        public ResponseEntity<Car> findById(@PathVariable Long id) {
            return ResponseEntity.ok(carService.findById(id));
        }

        @GetMapping("/model/{model}")
        public ResponseEntity<Car> findByModel(@PathVariable String model) {
            return ResponseEntity.ok(carService.findByModel(model));
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<Car> update(@PathVariable Long id, @RequestBody Car car) {
            Car updatedCar = carService.updateCar(id, car);
            return ResponseEntity.ok(updatedCar);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) {
            carService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }
}
