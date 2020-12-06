package ro.agilehub.javacourse.car.hire.user.service.definition;

import ro.agilehub.javacourse.car.hire.user.service.domain.UserDO;

import java.util.List;

public interface UserService {

    List<UserDO> findAllUsers();

    Integer createNewUser(UserDO example);
}
