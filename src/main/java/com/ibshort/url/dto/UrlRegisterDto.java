package com.ibshort.url.dto;

import com.ibshort.url.model.RedirectType;
import com.ibshort.url.validator.CorrectRedirectType;

import javax.validation.constraints.NotNull;

public class UrlRegisterDto {

    @NotNull(message = "Please provide url")
    private String url;

    @CorrectRedirectType
    private int redirectType;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRedirectType() {
        return RedirectType.fromValue(redirectType).name();
    }

    public void setRedirectType(int redirectType) {
        this.redirectType = redirectType;
    }
}
