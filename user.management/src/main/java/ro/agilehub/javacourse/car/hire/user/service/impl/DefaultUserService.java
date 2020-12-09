package ro.agilehub.javacourse.car.hire.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.user.repository.definition.UserRepository;
import ro.agilehub.javacourse.car.hire.user.repository.entity.User;
import ro.agilehub.javacourse.car.hire.user.service.definition.UserService;
import ro.agilehub.javacourse.car.hire.user.service.domain.UserDO;
import ro.agilehub.javacourse.car.hire.user.service.domain.UserStatusDO;
import ro.agilehub.javacourse.car.hire.user.service.mapper.UserDOMapper;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private final UserDOMapper userDOMapper;
    private final UserRepository userRepository;

    @Override
    public List<UserDO> findAllUsers() {
        List<UserDO> result = userDOMapper.toUserDOList(userRepository.findAll());
        if (result.isEmpty()) {
            throw new NoSuchElementException();
        }
        return result;
    }

    @Override
    public Integer createNewUser(UserDO example) {
        User newUser = userDOMapper.toUser(example);
        newUser = userRepository.save(newUser);
        return newUser.getId();
    }

    @Override
    public UserDO getById(Integer id) {
        return userDOMapper.toUserDO(getUserById(id));
    }

    @Override
    public void patchUser(Integer id, UserDO updateExample) {
        User user = getUserById(id);
        userDOMapper.patchUser(updateExample, user);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = getUserById(id);
        user.setStatus(UserStatusDO.DELETED.name());
        userRepository.save(user);
    }

    @Override
    public UserDO getByUsername(String username) {
        return userDOMapper.toUserDO(userRepository.findByUsernameIgnoreCase(username).orElseThrow());
    }

    private User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow();
    }
}
