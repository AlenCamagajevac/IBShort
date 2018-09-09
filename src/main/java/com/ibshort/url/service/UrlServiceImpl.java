package com.ibshort.url.service;

import com.ibshort.url.exception.UrlNotFoundException;
import com.ibshort.url.model.Url;
import com.ibshort.url.repository.UrlRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    UrlRepository urlRepository;

    @Override
    public void Save(Url url, String creatorId) {

        // Set shorten url
        String shortenUrl = RandomStringUtils.randomAlphanumeric(8);
        url.setShortenUrl(shortenUrl);

        // Set creator
        url.setCreatorId(creatorId);

        // Persist
        // TODO: Maybe set original url to unique.
        urlRepository.save(url);
    }

    @Override
    public Url getUrlByShortenUrl(String shortenUrl) {
        Url url = urlRepository.findByShortenUrl(shortenUrl);
        if(url == null) {
            throw new UrlNotFoundException("Url not found");
        }

        return url;
    }
}
