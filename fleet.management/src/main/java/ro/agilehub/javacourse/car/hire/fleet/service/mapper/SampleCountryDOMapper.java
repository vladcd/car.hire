package ro.agilehub.javacourse.car.hire.fleet.service.mapper;

import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.fleet.domain.SampleCountryDO;
import ro.agilehub.javacourse.car.hire.fleet.domain.SampleEntityDO;
import ro.agilehub.javacourse.car.hire.fleet.entity.SampleCountry;
import ro.agilehub.javacourse.car.hire.fleet.entity.SampleEntity;

@Component
public class SampleCountryDOMapper {

    public SampleCountryDO toDomainObject(SampleCountry sampleCountry) {
        if (sampleCountry == null) {
            return null;
        }
        return new SampleCountryDO.SampleCountryDOBuilder()
                .id(sampleCountry.getId().toHexString())
                .name(sampleCountry.getName())
                .isoCode(sampleCountry.getIsoCode())
                .build();
    }
}
