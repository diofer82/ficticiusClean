package apiRest.ficticiusClean.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    public Vehicle() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Long getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(Long idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public double getAvgConsumptionCity() {
        return avgConsumptionCity;
    }

    public void setAvgConsumptionCity(double avgConsumptionCity) {
        this.avgConsumptionCity = avgConsumptionCity;
    }

    public double getAvgConsumptionHighWays() {
        return avgConsumptionHighWays;
    }

    public void setAvgConsumptionHighWays(double avgConsumptionHighWays) {
        this.avgConsumptionHighWays = avgConsumptionHighWays;
    }
}