package by.tishalovichm.department.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends Exception {

    private final String message;

    private final HttpStatus httpStatus;

    public ApiException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public ApiException(String message) {
        this(message, HttpStatus.BAD_REQUEST);
    }

}
