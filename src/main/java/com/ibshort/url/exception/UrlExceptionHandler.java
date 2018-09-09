package com.ibshort.url.exception;

import com.ibshort.url.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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

}
