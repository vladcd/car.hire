package ro.agilehub.javacourse.car.hire.fleet.service.mapper;

import org.mapstruct.Mapper;

import ro.agilehub.javacourse.car.hire.api.model.CarDTO;
import ro.agilehub.javacourse.car.hire.fleet.entity.CarEntity;

@Mapper
public interface CarDOMapper {

		 CarDTO carToCarDto(CarEntity car);
		 CarEntity carDtoToCar(CarDTO carDTO);

}
