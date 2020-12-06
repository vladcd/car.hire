package ro.agilehub.javacourse.car.hire.user.service.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.user.repository.entity.Country;
import ro.agilehub.javacourse.car.hire.user.service.domain.CountryDO;

@Mapper(componentModel = "spring")
public interface CountryDOMapper {

    CountryDO toCountryDO(Country country);

    Country toCountry(CountryDO countryDO);
}
