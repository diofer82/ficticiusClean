package apiRest.ficticiusClean.controller;

import apiRest.ficticiusClean.model.Vehicle;
import apiRest.ficticiusClean.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/car")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping(path = "/listAll")
    public List<Vehicle> getVehicle(){
        return vehicleRepository.findAll();
    }

    @GetMapping(path = "/getById/id/{id}")
    public Optional<Vehicle> getVehicleById(@PathVariable(name = "id", required = true) Long id){
        return vehicleRepository.findById(id);
    }

    @PostMapping(path = "/saveAll")
    public void saveAllCar(@RequestBody List<Vehicle> vehicle){
        vehicle.forEach(vehicleRepository::saveAndFlush);
    }

    @PostMapping(path = "/save")
    public void saveCar(@RequestBody Vehicle vehicle){
        vehicleRepository.saveAndFlush(vehicle);
    }

    @DeleteMapping(path = "/deleteCarById/{id}")
    public void deleteCarById(@PathVariable(name = "id", required = true) Long id){
        vehicleRepository.deleteById(id);
    }

    @DeleteMapping(path = "/deleteCar")
    public void deleteCar(@RequestBody Vehicle vehicle){
        vehicleRepository.delete(vehicle);
    }

}
