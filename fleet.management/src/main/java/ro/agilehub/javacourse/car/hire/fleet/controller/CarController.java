package ro.agilehub.javacourse.car.hire.fleet.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ro.agilehub.javacourse.car.hire.api.model.CarDTO;
import ro.agilehub.javacourse.car.hire.api.specification.CarApi;
import ro.agilehub.javacourse.car.hire.fleet.controller.mapper.CarDTOMapper;
import ro.agilehub.javacourse.car.hire.fleet.service.definition.CarService;

@RestController
@RequiredArgsConstructor
public class CarController implements CarApi {

    private final CarDTOMapper carDTOMapper;
    private final CarService carService;

    @Override
    public ResponseEntity<CarDTO> getCar(Integer id) {
        return ResponseEntity.ok(carDTOMapper.toCarDTO(carService.getById(id)));
    }
}
