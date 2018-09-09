package com.ibshort.url.controllers;

import com.ibshort.common.identity.SecurityService;
import com.ibshort.url.dto.UrlDto;
import com.ibshort.url.dto.UrlRegisterDto;
import com.ibshort.url.mapper.UrlMapper;
import com.ibshort.url.model.Url;
import com.ibshort.url.service.UrlService;
import com.ibshort.url.service.UrlUsageMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class UrlController {

    @Autowired
    UrlService urlService;

    @Autowired
    UrlUsageMetricService urlUsageMetricService;

    @Autowired
    SecurityService securityService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<UrlDto> registerUrl(@RequestBody @Valid UrlRegisterDto registerDto) {

        // Map to domain models
        Url url = UrlMapper.INSTANCE.urlRegisterDtoToUrl(registerDto);

        // Persist
        urlService.Save(url, securityService.findLoggedInUsername());

        // Map to dto
        UrlDto urlDto = UrlMapper.INSTANCE.urlToUrlDto(url);

        return new ResponseEntity<>(urlDto, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{shortenUrl}", method = RequestMethod.GET)
    public void method(HttpServletResponse httpServletResponse, @PathVariable String shortenUrl) {

        // Find original url
        Url url = urlService.getUrlByShortenUrl(shortenUrl);

        // save usage metrics
        urlUsageMetricService.addMetric(url, securityService.findLoggedInUsername());

        // Redirect user
        httpServletResponse.setHeader("Location", url.getOriginalUrl());
        httpServletResponse.setStatus(url.getRedirectType().getStatusCode());
    }
}
