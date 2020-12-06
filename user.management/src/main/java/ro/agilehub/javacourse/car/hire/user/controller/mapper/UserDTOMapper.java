package ro.agilehub.javacourse.car.hire.user.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.agilehub.javacourse.car.hire.api.model.UserDTO;
import ro.agilehub.javacourse.car.hire.user.service.domain.UserDO;

import java.util.List;

@Mapper(componentModel = "spring", uses = CountryDTOMapper.class)
public interface UserDTOMapper {

    UserDTO toUserDTO(UserDO userDO);

    List<UserDTO> toUserDTOList(List<UserDO> userDOList);

    @Mapping(target = "id", ignore = true)
    UserDO toNewUserDO(UserDTO userDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "username", ignore = true)
    @Mapping(target = "password", ignore = true)
    UserDO toUserDO(UserDTO userDTO);
}
