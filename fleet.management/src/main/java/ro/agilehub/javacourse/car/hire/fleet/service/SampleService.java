package ro.agilehub.javacourse.car.hire.fleet.service;

import ro.agilehub.javacourse.car.hire.fleet.entity.SampleEntity;

import java.util.List;

public interface SampleService {

    List<SampleEntity> findAll();

    SampleEntity findById(Integer id);

}
