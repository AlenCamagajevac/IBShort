package com.ibshort.auth.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class UserCreateDto {

    @NotNull(message = "AccountId should be provided.")
    @Length(min = 3, max = 50, message = "AccountId should be between {min} and {max} characters.")
    private String accountId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
