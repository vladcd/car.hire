package ro.agilehub.javacourse.car.hire.fleet.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "car")
@Data
@EqualsAndHashCode(of = "id")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String make;
    private String model;
    private Integer year;
    private Integer mileage;
    private String fuel;
    private String carClass;
    private String status;

}
