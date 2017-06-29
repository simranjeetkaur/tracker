package io.egen.simran.service;

import io.egen.simran.entity.Vehicle;
import io.egen.simran.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Vehicle findByVin(String vehicleVin) {
        return vehicleRepository.findByVin(vehicleVin);
    }

    @Transactional
    public void create(Vehicle vehicle) {
        System.out.println("In vehicle service is: "+vehicle.toString());
        vehicleRepository.create(vehicle);
    }

    @Transactional
    public Vehicle update(String vehicleVin, Vehicle vehicle) {
        return vehicleRepository.update(vehicleVin, vehicle);
    }

    @Transactional
    public void delete(Vehicle vehicle) {
        vehicleRepository.delete(vehicle);
    }
}
