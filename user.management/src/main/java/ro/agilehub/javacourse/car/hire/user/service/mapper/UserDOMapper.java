package ro.agilehub.javacourse.car.hire.user.service.mapper;

import org.mapstruct.*;
import ro.agilehub.javacourse.car.hire.user.repository.entity.User;
import ro.agilehub.javacourse.car.hire.user.service.domain.UserDO;

import java.util.List;

@Mapper(componentModel = "spring", uses = CountryDOMapper.class)
public interface UserDOMapper {

    UserDO toUserDO(User user);

    List<UserDO> toUserDOList(List<User> userList);

    User toUser(UserDO userDO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "username", ignore = true)
    @Mapping(target = "password", ignore = true)
    void patchUser(UserDO userDO, @MappingTarget User user);
}
