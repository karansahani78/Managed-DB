package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<ManagedDbApplication.Car, Long> {
    ManagedDbApplication.Car findByModel(String model);
}