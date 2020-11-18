package ro.agilehub.javacourse.car.hire.fleet.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.fleet.domain.SampleEntityDO;
import ro.agilehub.javacourse.car.hire.fleet.entity.SampleCountry;
import ro.agilehub.javacourse.car.hire.fleet.entity.SampleEntity;

@Component
public class SampleEntityDOMapper {

    @Autowired
    private SampleCountryDOMapper countryDOMapper;

    public SampleEntityDO toDomainObject(SampleEntity sampleEntity, SampleCountry sampleCountry) {
        if (sampleEntity == null) {
            return null;
        }
        return new SampleEntityDO.SampleEntityDOBuilder()
                .id(sampleEntity.getId().toHexString())
                .name(sampleEntity.getName())
                .country(countryDOMapper.toDomainObject(sampleCountry))
                .build();
    }

}
