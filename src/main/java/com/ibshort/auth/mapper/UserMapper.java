package com.ibshort.auth.mapper;

import com.ibshort.auth.dto.UserCreateDto;
import com.ibshort.auth.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "accountId", target = "username")
    User userCreateDtoToUser(UserCreateDto createDto);
}
