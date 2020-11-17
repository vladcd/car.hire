package ro.agilehub.javacourse.car.hire.fleet.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ro.agilehub.javacourse.car.hire.api.model.Car;
import ro.agilehub.javacourse.car.hire.api.model.ResourceCreatedDTO;
import ro.agilehub.javacourse.car.hire.api.model.ResponseDTO;
import ro.agilehub.javacourse.car.hire.api.specification.FleetApi;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FleetController implements FleetApi {

    @Override
    public ResponseEntity<ResourceCreatedDTO> addCarToFleet(@Valid Car car) {
        ResourceCreatedDTO resourceCreatedDTO = new ResourceCreatedDTO();
        resourceCreatedDTO.setId(1L);
        return ResponseEntity.ok(resourceCreatedDTO);
    }

    @Override
    public ResponseEntity<ResponseDTO> deleteCar(Integer id) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Delete operations has been done for car " + id);
        return ResponseEntity.ok(responseDTO);
    }

    @Override
    public ResponseEntity<List<Car>> getAllCarsFromFleet(@Valid String status) {
        List<Car> cars = new ArrayList<>();
        cars.add(mockCar());
        return ResponseEntity.ok(cars);
    }

    @Override
    public ResponseEntity<Car> getCarByID(Integer id) {
        return ResponseEntity.ok(mockCar());
    }

    @Override
    public ResponseEntity<ResponseDTO> updateCarDetails(Integer id, @Valid Car car) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Car has been updated successfully");
        return ResponseEntity.ok(responseDTO);
    }

    private Car mockCar() {
        Car car = new Car();
        car.setCarClass("Sedan");
        car.setFuel(100f);
        car.setId(1L);
        car.setYear(2020);
        car.setMake("BMW");
        car.setMileage(1000L);
        car.setModel("3 series");
        car.setStatus("ACTIVE");
        return car;
    }
}
