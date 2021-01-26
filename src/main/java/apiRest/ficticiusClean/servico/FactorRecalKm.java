package apiRest.ficticiusClean.servico;

import apiRest.ficticiusClean.model.Refuel;

import java.math.BigDecimal;

public class FactorRecalKm {

    public Refuel updateKm(Refuel refuel){

        if (refuel.getTypeRoute().equals("ROAD")) {
            refuel.setPriceTotal(new BigDecimal((refuel.getTotalKmTraveled() / refuel.getVehicle().getAvgConsumptionCity()) * refuel.getPriceFuel()));
        }else {
            refuel.setPriceTotal(new BigDecimal((refuel.getTotalKmTraveled() / refuel.getVehicle().getAvgConsumptionHighWays()) * refuel.getPriceFuel()));
        }
        return refuel;
    }
}
