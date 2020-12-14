package ro.agilehub.javacourse.car.hire.user.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ro.agilehub.javacourse.car.hire.user.repository.definition.UserRepository;
import ro.agilehub.javacourse.car.hire.user.repository.entity.User;
import ro.agilehub.javacourse.car.hire.user.service.domain.UserDO;
import ro.agilehub.javacourse.car.hire.user.service.exception.ErrorCode;
import ro.agilehub.javacourse.car.hire.user.service.exception.UserManagementValidationException;
import ro.agilehub.javacourse.car.hire.user.service.mapper.UserDOMapper;
import ro.agilehub.javacourse.car.hire.user.service.validator.UserServiceValidator;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DefaultUserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserDOMapper userDOMapper;

    @Mock
    private UserServiceValidator userServiceValidator;

    @InjectMocks
    private DefaultUserService defaultUserService;

    @Test
    public void findAllUsers_whenEmpty_thenException() {
        List<User> repoUsers = Collections.emptyList();
        List<UserDO> doUsers = Collections.emptyList();

        when(userRepository.findAll()).thenReturn(repoUsers);
        when(userDOMapper.toUserDOList(repoUsers)).thenReturn(doUsers);

        assertThrows(NoSuchElementException.class, () -> defaultUserService.findAllUsers());
    }

    @Test
    public void findAllUsers_whenUsers_thenResult() {
        UserDO userDO = mock(UserDO.class);
        List<UserDO> doUsers = List.of(userDO);

        when(userDOMapper.toUserDOList(any())).thenReturn(doUsers);

        assertEquals(1, defaultUserService.findAllUsers().size());
    }

    @Test
    public void createNewUser_whenValidationErrors_thenExpectException() {
        UserDO userDO = mock(UserDO.class);
        UserDO sameUserDO = mock(UserDO.class);
        User sameUser = mock(User.class);

        when(userRepository.findByEmailIgnoreCase(any())).thenReturn(Optional.of(sameUser));
        when(userDOMapper.toUserDO(sameUser)).thenReturn(sameUserDO);
        when(userServiceValidator.validateChangeUser(eq(userDO), any())).thenReturn(List.of(ErrorCode.DUPLICATE_EMAIL));

        assertThrows(UserManagementValidationException.class, () -> defaultUserService.createNewUser(userDO));
    }

    @Test
    public void patchUser_whenValidationErrors_thenExpectException() {
        final Integer id = 1;
        UserDO userDO = mock(UserDO.class);

        when(userServiceValidator.validateChangeUser(eq(userDO), any())).thenReturn(List.of(ErrorCode.DUPLICATE_EMAIL));

        assertThrows(UserManagementValidationException.class, () -> defaultUserService.patchUser(id, userDO));
    }
}
