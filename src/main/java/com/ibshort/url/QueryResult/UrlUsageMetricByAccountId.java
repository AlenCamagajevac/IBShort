package com.ibshort.url.QueryResult;

public class UrlUsageMetricByAccountId {

    private String originalUrl;
    private Long accessCount;

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public Long getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(Long accessCount) {
        this.accessCount = accessCount;
    }

    public UrlUsageMetricByAccountId(String originalUrl, Long accessCount) {
        this.originalUrl = originalUrl;
        this.accessCount = accessCount;
    }
}