package com.ibshort.url.repository;

import com.ibshort.url.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    Url findByShortenUrl(String shortenUrl);
}
