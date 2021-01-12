package ro.agilehub.javacourse.car.hire.fleet.service.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.fleet.repository.entity.Car;
import ro.agilehub.javacourse.car.hire.fleet.service.entity.CarDO;

@Mapper(componentModel = "spring")
public interface CarDOMapper {

    CarDO toCarDO(Car car);

    Car toCar(CarDO carDO);
}
