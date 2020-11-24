package ro.agilehub.javacourse.car.hire.fleet.service.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.fleet.domain.SampleCountryDO;
import ro.agilehub.javacourse.car.hire.fleet.entity.SampleCountry;

@Mapper(componentModel = "spring", uses = ObjectIdMapper.class)
public interface SampleCountryDOMapper {

    SampleCountryDO toDomainObject(SampleCountry sampleCountry);

}
