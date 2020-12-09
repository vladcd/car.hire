package ro.agilehub.javacourse.car.hire.user.service.definition;

import ro.agilehub.javacourse.car.hire.user.service.domain.UserDO;

import java.util.List;

public interface UserService {

    List<UserDO> findAllUsers();

    Integer createNewUser(UserDO example);

    UserDO getById(Integer id);

    void patchUser(Integer id, UserDO updateExample);

    void deleteUser(Integer id);

    UserDO getByUsername(String username);
}
