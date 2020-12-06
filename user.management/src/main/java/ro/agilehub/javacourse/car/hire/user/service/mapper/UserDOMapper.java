package ro.agilehub.javacourse.car.hire.user.service.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.user.repository.entity.User;
import ro.agilehub.javacourse.car.hire.user.service.domain.UserDO;

import java.util.List;

@Mapper(componentModel = "spring", uses = CountryDOMapper.class)
public interface UserDOMapper {

    UserDO toUserDO(User user);

    List<UserDO> toUserDOList(List<User> userList);

    User toUser(UserDO userDO);
}
