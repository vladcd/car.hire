package ro.agilehub.javacourse.car.hire.fleet.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.agilehub.javacourse.car.hire.fleet.domain.SampleEntityDO;
import ro.agilehub.javacourse.car.hire.fleet.entity.SampleCountry;
import ro.agilehub.javacourse.car.hire.fleet.entity.SampleEntity;

@Mapper(componentModel = "spring", uses = {SampleCountryDOMapper.class, ObjectIdMapper.class})
public interface SampleEntityDOMapper {

    @Mapping(target = "country", source = "sampleCountry")
    @Mapping(target = "id", source = "sampleEntity.id")
    @Mapping(target = "name", source = "sampleEntity.name")
    SampleEntityDO toDomainObject(SampleEntity sampleEntity, SampleCountry sampleCountry);

}
