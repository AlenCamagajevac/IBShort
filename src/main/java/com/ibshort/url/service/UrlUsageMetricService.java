package com.ibshort.url.service;

import com.ibshort.url.QueryResult.UrlUsageMetricByAccountId;
import com.ibshort.url.model.Url;

import java.util.List;

public interface UrlUsageMetricService {

    void addMetric(Url url, String accountId);

    List<UrlUsageMetricByAccountId> getMetricForAccountId(String accountId);

}
