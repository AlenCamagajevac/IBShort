package com.ibshort.url.exception;

import com.ibshort.url.dto.ErrorResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice("com.ibshort.url")
public class UrlExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UrlNotFoundException.class)
    protected ResponseEntity<ErrorResponseDto> handleUrlNotFound(UrlNotFoundException ex,
                                                                                WebRequest request) {

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ex.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoUsageStatisticsFoundException.class)
    protected ResponseEntity<ErrorResponseDto> handleNoUserMetrics(NoUsageStatisticsFoundException ex,
                                                                                WebRequest request) {

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ex.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                   HttpHeaders headers,
                                                   HttpStatus status,
                                                   WebRequest request) {

        return new ResponseEntity<>(ex.getBindingResult()
                .getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList()), HttpStatus.BAD_REQUEST);
    }

}
