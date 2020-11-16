package ro.agilehub.javacourse.car.hire.fleet.service;

import ro.agilehub.javacourse.car.hire.fleet.domain.SampleEntityDO;

import java.util.List;

public interface SampleService {

    List<SampleEntityDO> findAll();

    SampleEntityDO findById(String id);

}
