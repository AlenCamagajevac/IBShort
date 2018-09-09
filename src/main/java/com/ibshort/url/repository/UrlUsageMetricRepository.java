package com.ibshort.url.repository;

import com.ibshort.url.QueryResult.UrlUsageMetricByAccountId;
import com.ibshort.url.model.UrlUsageMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlUsageMetricRepository extends JpaRepository<UrlUsageMetric, Long> {

    @Query("SELECT new com.ibshort.url.QueryResult.UrlUsageMetricByAccountId(u.originalUrl," +
            " COUNT(um.id))" +
            "FROM Url u\n" +
            "inner JOIN UrlUsageMetric um on um.url.id = u.id\n" +
            "WHERE um.accountId = ?1 \n" +
            "GROUP BY u.originalUrl")
    List<UrlUsageMetricByAccountId> getMetricForAccountId(String accountId);
}
