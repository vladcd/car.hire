package ro.agilehub.javacourse.car.hire.user.controller.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.api.model.CountryDTO;
import ro.agilehub.javacourse.car.hire.user.service.domain.CountryDO;

@Mapper(componentModel = "spring")
public interface CountryDTOMapper {

    CountryDTO toCountryDTO(CountryDO countryDO);

    CountryDO toCountryDO(CountryDTO countryDTO);
}
