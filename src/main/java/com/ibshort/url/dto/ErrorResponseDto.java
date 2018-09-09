package com.ibshort.url.dto;

public class ErrorResponseDto {

    // TODO: Add status code enum

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorResponseDto(String message) {
        this.message = message;
    }
}
