package io.egen.simran.Controller;

import io.egen.simran.entity.Vehicle;
import io.egen.simran.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value="/vehicles")
public class VehicleController {

    @Autowired
    VehicleService service;

        @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public List<Vehicle> findAll() {
            return service.findAll();
        }

        @RequestMapping(method = RequestMethod.GET, value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public Vehicle findOne(@PathVariable("id") String vehicleVin) {
          return service.findByVin(vehicleVin);
        }
        @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value="/create")
        public void create(@RequestBody List<Vehicle> vehicle) {

            if (vehicle != null) {
                System.out.println("In vehicle controller now, is: " + vehicle);
                for (Vehicle vh : vehicle) {
                    System.out.println("In vehicle controller still, the vehicle object is: "+vh);
                    service.create(vh);
                }
            }
        }

        @RequestMapping(method = RequestMethod.PUT, value = "/{id}",
                consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public Vehicle update(@PathVariable("id") String vehicleVin, @RequestBody Vehicle vehicle) {
            return service.update(vehicleVin, vehicle);
        }

        @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
        public void delete(@PathVariable("id") Vehicle vehicle) {
            service.delete(vehicle);
        }
}

