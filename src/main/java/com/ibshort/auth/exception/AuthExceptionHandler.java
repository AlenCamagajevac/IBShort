package com.ibshort.auth.exception;

import com.ibshort.auth.dto.UserCreatedDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice("com.ibshort.auth")
public class AuthExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    protected ResponseEntity<UserCreatedDto> handleUserAlreadyExistsException(UserAlreadyExistsException ex,
                                                                              WebRequest request) {

        UserCreatedDto createdDto = new UserCreatedDto(false, ex.getMessage(), null);
        return new ResponseEntity<>(createdDto, HttpStatus.BAD_REQUEST);
    }

}
