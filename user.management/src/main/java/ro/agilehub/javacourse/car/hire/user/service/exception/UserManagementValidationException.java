package ro.agilehub.javacourse.car.hire.user.service.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class UserManagementValidationException extends RuntimeException {

    private final List<ErrorCode> errorCodes;

    public UserManagementValidationException(List<ErrorCode> errorCodes) {
        super();
        this.errorCodes = errorCodes;
    }
}
