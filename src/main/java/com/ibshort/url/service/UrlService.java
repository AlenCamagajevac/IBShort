package com.ibshort.url.service;

import com.ibshort.url.model.Url;

public interface UrlService {

    void Save(Url url, String creatorId);

    Url getUrlByShortenUrl(String shortenUrl);
}
