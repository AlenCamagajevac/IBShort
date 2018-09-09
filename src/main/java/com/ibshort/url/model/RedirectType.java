package com.ibshort.url.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RedirectType {
    MOVED (301, "moved"),
    PERMANENT_REDIRECT (302, "permanent_redirect");

    private final int statusCode;
    private final String verb;

    RedirectType(int statusCode, String verb) {
        this.verb = verb;
        this.statusCode = statusCode;
    }

    @JsonValue
    public int getStatusCode() {
        return statusCode;
    }

    public String getVerb() {
        return verb;
    }

    @JsonCreator
    public static RedirectType fromValue(int value) {
        for (RedirectType redirectType : values()) {
            if(redirectType.statusCode == value) {
                return redirectType;
            }
        }

        // TODO: throw custom exception
        throw new IllegalArgumentException("Unknown enum type");
    }
}
