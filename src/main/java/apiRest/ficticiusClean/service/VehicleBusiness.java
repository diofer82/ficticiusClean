package apiRest.ficticiusClean.service;

import apiRest.ficticiusClean.model.Vehicle;
import apiRest.ficticiusClean.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class VehicleBusiness {
    @Autowired
    private VehicleRepository vehicleRepository;

    public void save(Vehicle vehicle){
        vehicleRepository.saveAndFlush(vehicle);
    }

    public Optional<Vehicle> getById(Long id){
        return vehicleRepository.findById(id);
    }
}
