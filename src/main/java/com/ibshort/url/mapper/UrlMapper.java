package com.ibshort.url.mapper;

import com.ibshort.url.dto.UrlDto;
import com.ibshort.url.dto.UrlRegisterDto;
import com.ibshort.url.model.Url;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UrlMapper {

    UrlMapper INSTANCE = Mappers.getMapper(UrlMapper.class);


    @Mappings({
            @Mapping(source = "redirectType", target = "redirectType"),
            @Mapping(source = "url", target = "originalUrl")
    })
    Url urlRegisterDtoToUrl(UrlRegisterDto registerDto);

    UrlDto urlToUrlDto(Url url);
}
