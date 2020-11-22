package ro.agilehub.javacourse.car.hire.fleet.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.fleet.domain.SampleEntityDO;
import ro.agilehub.javacourse.car.hire.fleet.entity.SampleCountry;
import ro.agilehub.javacourse.car.hire.fleet.entity.SampleEntity;
import ro.agilehub.javacourse.car.hire.fleet.repository.SampleCountryRepository;
import ro.agilehub.javacourse.car.hire.fleet.repository.SampleEntityRepository;
import ro.agilehub.javacourse.car.hire.fleet.service.mapper.SampleEntityDOMapper;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class DefaultSampleService implements SampleService {

    @Autowired
    private SampleEntityRepository sampleEntityRepository;

    @Autowired
    private SampleCountryRepository sampleCountryRepository;

    @Autowired
    private SampleEntityDOMapper mapper;

    @Override
    public List<SampleEntityDO> findAll() {
        return sampleEntityRepository.findAll()
                .stream()
                .map(this::map)
                .collect(toList());
    }

    @Override
    public SampleEntityDO findById(String id) {
        return sampleEntityRepository.findById(new ObjectId(id))
                .map(this::map)
                .orElseThrow();
    }

    private SampleEntityDO map(SampleEntity sampleEntity) {
        var sampleCountry = sampleCountryRepository
                .findById(new ObjectId(sampleEntity.getCountry()))
                .orElse(null);
        return mapper.toDomainObject(sampleEntity, sampleCountry);
    }

}
