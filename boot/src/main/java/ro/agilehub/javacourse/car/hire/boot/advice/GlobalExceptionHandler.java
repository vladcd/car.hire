package ro.agilehub.javacourse.car.hire.boot.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ro.agilehub.javacourse.car.hire.api.model.ValidationDTO;
import ro.agilehub.javacourse.car.hire.user.service.exception.UserManagementValidationException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public void handleNotFound() {
        // Nothing to do
    }

    @ExceptionHandler(UserManagementValidationException.class)
    public ResponseEntity<List<ValidationDTO>> handleValidationException(UserManagementValidationException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exception.getErrorCodes().stream()
                        .map(errorCode -> new ValidationDTO()
                                .code(errorCode.getCode().toString())
                                .description(errorCode.name()))
                        .collect(Collectors.toList()));
    }
}
