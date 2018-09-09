package com.ibshort.url.dto;

import com.ibshort.url.model.RedirectType;

public class UrlRegisterDto {

    private String url;

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
