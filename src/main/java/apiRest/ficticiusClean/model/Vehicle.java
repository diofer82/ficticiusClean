package apiRest.ficticiusClean.model;


import javax.persistence.*;
import java.util.Date;

@Entity(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idVehicle;

    @Column
    String name;

    @Column
    String mark;

    @Column
    String model;

    @Temporal(TemporalType.TIMESTAMP)
    Date manufacturingDate;

    @Column
    double avgConsumptionCity;

    @Column
    double avgConsumptionHighWays;

}