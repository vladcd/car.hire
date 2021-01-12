package ro.agilehub.javacourse.car.hire.fleet.service.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ro.agilehub.javacourse.car.hire.api.model.CarClass;
import ro.agilehub.javacourse.car.hire.api.model.CarStatus;
import ro.agilehub.javacourse.car.hire.api.model.FuelType;

@Data
@EqualsAndHashCode(of = "id")
public class CarDO {

    private Integer id;
    private String make;
    private String model;
    private Integer year;
    private Integer mileage;
    private FuleTypeDO fuel;
    private CarClassDO carClass;
    private CarStatusDO status;
}
