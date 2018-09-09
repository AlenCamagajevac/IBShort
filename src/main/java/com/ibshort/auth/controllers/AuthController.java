package com.ibshort.auth.controllers;

import com.ibshort.auth.dto.UserCreateDto;
import com.ibshort.auth.dto.UserCreatedDto;
import com.ibshort.auth.mapper.UserMapper;
import com.ibshort.auth.model.User;
import com.ibshort.common.identity.SecurityService;
import com.ibshort.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public ResponseEntity<UserCreatedDto> registerAccount(@RequestBody UserCreateDto createDto) {

        // Map dto to domain model
        User user = UserMapper.INSTANCE.userCreateDtoToUser(createDto);

        // Save user
        String password = userService.save(user);

        // Construct response object
        UserCreatedDto userCreatedDto = new UserCreatedDto(true,
                "Your account is opened", password);

        return new ResponseEntity<>(userCreatedDto, HttpStatus.CREATED);
    }


}
