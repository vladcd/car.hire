package ro.agilehub.javacourse.car.hire.user.service.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import ro.agilehub.javacourse.car.hire.user.service.domain.UserDO;
import ro.agilehub.javacourse.car.hire.user.service.exception.ErrorCode;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceValidatorTest {

    @InjectMocks
    private UserServiceValidator userServiceValidator;

    @Test
    public void validateChangeUser_whenBothWrong_thenExpectErrors() {
        final Integer id = 1;
        final Integer anotherId = 2;
        final String email = "vladcarcu@email.com";
        final String username = "vladcarcu";

        UserDO userDO = mock(UserDO.class);
        when(userDO.getId()).thenReturn(id);

        UserDO sameUser = mock(UserDO.class);
        when(sameUser.getId()).thenReturn(anotherId);

        var errorCodes = userServiceValidator.validateChangeUser(userDO, UserServiceValidator.Input.builder()
                .userWithSameEmail(sameUser)
                .userWithSameUsername(sameUser)
                .build());

        assertArrayEquals(new ErrorCode[]{
                ErrorCode.DUPLICATE_EMAIL, ErrorCode.DUPLICATE_USERNAME
        }, errorCodes.toArray(new ErrorCode[]{}));
    }
}
