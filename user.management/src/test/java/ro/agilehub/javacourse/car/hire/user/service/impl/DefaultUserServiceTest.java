package ro.agilehub.javacourse.car.hire.user.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ro.agilehub.javacourse.car.hire.user.repository.definition.UserRepository;
import ro.agilehub.javacourse.car.hire.user.repository.entity.User;
import ro.agilehub.javacourse.car.hire.user.service.domain.UserDO;
import ro.agilehub.javacourse.car.hire.user.service.mapper.UserDOMapper;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultUserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserDOMapper userDOMapper;

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
}
