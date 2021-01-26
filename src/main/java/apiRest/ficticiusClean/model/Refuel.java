package apiRest.ficticiusClean.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

import static javax.persistence.FetchType.EAGER;

@Getter
@Setter
@Entity
@Table(name = "refuel")
public class Refuel {

    public Refuel() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "idVehicle")
    Vehicle vehicle;

    @Column
    Double priceFuel;

    @Column
    Double totalKmTraveled;

    @Column
    TypeRoute typeRoute;

    @Column(precision = 13, scale = 4)
    BigDecimal priceTotal;

}
