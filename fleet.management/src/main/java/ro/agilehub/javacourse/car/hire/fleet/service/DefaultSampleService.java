package ro.agilehub.javacourse.car.hire.fleet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.fleet.entity.SampleEntity;
import ro.agilehub.javacourse.car.hire.fleet.repository.SampleEntityRepository;

import java.util.List;

@Service
public class DefaultSampleService implements SampleService {

    @Autowired
    private SampleEntityRepository sampleEntityRepository;

    @Override
    public List<SampleEntity> findAll() {
        return sampleEntityRepository.findAll();
    }

    @Override
    public SampleEntity findById(Integer id) {
        return sampleEntityRepository.findById(id).orElseThrow();
    }
}
