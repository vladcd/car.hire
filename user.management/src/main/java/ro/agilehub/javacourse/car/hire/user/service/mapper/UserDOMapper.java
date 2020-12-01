package ro.agilehub.javacourse.car.hire.user.service.mapper;

import org.mapstruct.Mapper;

import ro.agilehub.javacourse.car.hire.api.model.UserDTO;
import ro.agilehub.javacourse.car.hire.user.entity.UserEntity;

@Mapper
public interface UserDOMapper {
	 UserDTO userToUserDto(UserEntity user);
	 UserEntity userDtoToUser(UserDTO userDto);
}
