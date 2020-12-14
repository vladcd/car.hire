package ro.agilehub.javacourse.car.hire.user.service.validator;

import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.user.service.domain.UserDO;
import ro.agilehub.javacourse.car.hire.user.service.exception.ErrorCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceValidator {

    @Builder
    @Getter
    public static class Input {
        private UserDO userWithSameEmail;
        private UserDO userWithSameUsername;
    }

    public List<ErrorCode> validateChangeUser(UserDO userDO, Input input) {
        List<ErrorCode> validationErrors = new ArrayList<>();
        Optional.ofNullable(input.getUserWithSameEmail())
                .filter(sameUser -> !sameUser.getId().equals(userDO.getId()))
                .flatMap(sameUser -> Optional.of(ErrorCode.DUPLICATE_EMAIL))
                .ifPresent(validationErrors::add);
        Optional.ofNullable(input.getUserWithSameUsername())
                .filter(sameUser -> !sameUser.getId().equals(userDO.getId()))
                .flatMap(sameUser -> Optional.of(ErrorCode.DUPLICATE_USERNAME))
                .ifPresent(validationErrors::add);
        return validationErrors;
    }

}
