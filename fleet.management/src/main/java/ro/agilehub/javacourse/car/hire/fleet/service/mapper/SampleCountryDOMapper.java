package ro.agilehub.javacourse.car.hire.fleet.service.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.fleet.domain.SampleCountryDO;
import ro.agilehub.javacourse.car.hire.fleet.domain.SampleEntityDO;
import ro.agilehub.javacourse.car.hire.fleet.entity.SampleCountry;
import ro.agilehub.javacourse.car.hire.fleet.entity.SampleEntity;

@Mapper(componentModel = "spring", uses = ObjectIdMapper.class)
public interface SampleCountryDOMapper {

    SampleCountryDO toDomainObject(SampleCountry sampleCountry);

}
