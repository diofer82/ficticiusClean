package apiRest.ficticiusClean.controller;

import apiRest.ficticiusClean.service.VehicleBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

    @Autowired
    VehicleBusiness vehicleBusiness;

    @GetMapping(path = "api/car/{id}")
    public void getVehicle(@PathVariable(name = "id", required = true) Long id){
        ResponseEntity.ok(vehicleBusiness.getById(id));
    }
}
