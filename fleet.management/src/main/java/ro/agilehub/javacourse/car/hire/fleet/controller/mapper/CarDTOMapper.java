package ro.agilehub.javacourse.car.hire.fleet.controller.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.api.model.CarDTO;
import ro.agilehub.javacourse.car.hire.fleet.service.entity.CarDO;

@Mapper(componentModel = "spring")
public interface CarDTOMapper {

    CarDTO toCarDTO(CarDO carDO);

    CarDO toCarDO(CarDTO carDTO);
}
