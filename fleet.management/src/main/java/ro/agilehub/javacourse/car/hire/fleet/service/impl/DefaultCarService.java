package ro.agilehub.javacourse.car.hire.fleet.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.fleet.repository.definition.CarRepository;
import ro.agilehub.javacourse.car.hire.fleet.service.definition.CarService;
import ro.agilehub.javacourse.car.hire.fleet.service.entity.CarDO;
import ro.agilehub.javacourse.car.hire.fleet.service.mapper.CarDOMapper;

@Service
@RequiredArgsConstructor
public class DefaultCarService implements CarService {

    private final CarRepository carRepository;
    private final CarDOMapper carDOMapper;

    @Override
    public CarDO getById(Integer id) {
        return carDOMapper.toCarDO(carRepository.findById(id).orElseThrow());
    }
}
