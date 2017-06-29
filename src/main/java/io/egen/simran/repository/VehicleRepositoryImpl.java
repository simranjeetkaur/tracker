package io.egen.simran.repository;

import io.egen.simran.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.loadVehicles", Vehicle.class);
        return query.getResultList();
    }

    public Vehicle findByVin(String vehicleVin) {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findByVin", Vehicle.class);
        query.setParameter("paramVin", vehicleVin);
        List<Vehicle> resultList = query.getResultList();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }
    }

    public void create(Vehicle vehicle) {
        System.out.println("In vehicle repo is: "+vehicle.toString());
        entityManager.getTransaction().begin();
        entityManager.persist(vehicle);
        entityManager.getTransaction().commit();
    }

    public Vehicle update(String vehicleVin, Vehicle vehicle) {
        return entityManager.merge(vehicle);
    }

    public void delete(Vehicle vehicle) {
        entityManager.remove(vehicle);
    }
}
