package ro.agilehub.javacourse.car.hire.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.user.repository.definition.UserRepository;
import ro.agilehub.javacourse.car.hire.user.repository.entity.User;
import ro.agilehub.javacourse.car.hire.user.service.definition.UserService;
import ro.agilehub.javacourse.car.hire.user.service.domain.UserDO;
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
}
