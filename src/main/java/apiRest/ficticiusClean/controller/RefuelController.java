package apiRest.ficticiusClean.controller;

import apiRest.ficticiusClean.model.Refuel;
import apiRest.ficticiusClean.repository.RefuelRepository;
import apiRest.ficticiusClean.servico.FactorRecalKm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import javax.inject.Inject;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/refuel")
public class RefuelController {

    @Autowired
    private RefuelRepository refuelRepository;

    @Inject
    private FactorRecalKm factorRecalKm;

    @GetMapping(path = "/listAll")
    public List<Refuel> getRefuel(){
        return refuelRepository.findAll(Sort.by(Sort.Direction.DESC, "priceTotal"));
    }

    @GetMapping(path = "/getById/id/{id}")
    public Optional<Refuel> getRefuelById(@PathVariable(name = "id", required = true) Long id){
        return refuelRepository.findById(id);
    }

    @PostMapping(path = "/save")
    public void saveRefuel(@RequestBody Refuel refuel){
        if (refuel.getTypeRoute().equals("ROAD")) {
            refuel.setPriceTotal(new BigDecimal((refuel.getTotalKmTraveled() / refuel.getVehicle().getAvgConsumptionCity()) * refuel.getPriceFuel()));
        }else {
            refuel.setPriceTotal(new BigDecimal((refuel.getTotalKmTraveled() / refuel.getVehicle().getAvgConsumptionHighWays()) * refuel.getPriceFuel()));
        }
        refuelRepository.saveAndFlush(refuel);
    }

    @DeleteMapping(path = "/deleteRefuelById/{id}")
    public void deleteRefuelById(@PathVariable(name = "id", required = true) Long id){
        refuelRepository.deleteById(id);
    }

    @DeleteMapping(path = "/deleteRefuel")
    public void deleteRefuel(@RequestBody Refuel Refuel){
        refuelRepository.delete(Refuel);
    }

}