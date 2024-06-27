package by.tishalovichm.webbff.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ExceptionInfo> handleResourceNotFound(
            ResourceNotFoundException e) {

        return new ResponseEntity<>(
                new ExceptionInfo(
                        String.format("Resource with %s = %s not found",
                                e.getField(),
                                e.getValue().toString())
                ),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ExceptionInfo> handleApiException(
            ApiException e) {

        return new ResponseEntity<>(
                new ExceptionInfo(
                        e.getMessage()
                ),
                e.getHttpStatus()
        );
    }

}
