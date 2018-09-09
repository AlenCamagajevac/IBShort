package com.ibshort.auth.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class UserCreatedDto {

    private boolean successful;
    private String description;
    private String password;

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserCreatedDto() {

    }

    public UserCreatedDto(boolean successful, String description, String password) {
        this.successful = successful;
        this.description = description;
        this.password = password;
    }
}
