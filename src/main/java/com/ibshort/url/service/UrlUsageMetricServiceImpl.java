package com.ibshort.url.service;

import com.ibshort.url.QueryResult.UrlUsageMetricByAccountId;
import com.ibshort.url.exception.NoUsageStatisticsFoundException;
import com.ibshort.url.model.Url;
import com.ibshort.url.model.UrlUsageMetric;
import com.ibshort.url.repository.UrlUsageMetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlUsageMetricServiceImpl implements UrlUsageMetricService {

    @Autowired
    UrlUsageMetricRepository urlUsageMetricRepository;

    @Override
    public void addMetric(Url url, String accountId) {

        // Set account id that used url
        UrlUsageMetric urlUsageMetric = new UrlUsageMetric(url, accountId);

        // Persist
        urlUsageMetricRepository.save(urlUsageMetric);
    }

    @Override
    public List<UrlUsageMetricByAccountId> getMetricForAccountId(String accountId) {
        List<UrlUsageMetricByAccountId> metrics = urlUsageMetricRepository.getMetricForAccountId(accountId);

        if(metrics == null || metrics.isEmpty()) {
            throw new NoUsageStatisticsFoundException("No statistics were found for user.");
        }

        return metrics;
    }
}
