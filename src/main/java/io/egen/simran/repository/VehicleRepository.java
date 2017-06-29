package io.egen.simran.repository;

import io.egen.simran.entity.Vehicle;

import java.util.List;

public interface VehicleRepository {
    List<Vehicle> findAll();

    Vehicle findByVin(String vehicleVin);

    void create(Vehicle vehicle);

    Vehicle update(String vehicleVin, Vehicle vehicle);

    void delete(Vehicle vehicle);
}
