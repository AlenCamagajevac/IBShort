package com.ibshort.auth.service;

import com.ibshort.auth.exception.UserAlreadyExistsException;
import com.ibshort.auth.model.User;
import com.ibshort.auth.repository.AuthorityRepository;
import com.ibshort.auth.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String save(User user) {

        // Check if user is already registered
        if(userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistsException("User with given accountId already exists");
        }

        // Generate users password and add him to all roles
        String password = RandomStringUtils.randomAlphanumeric(8);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setAuthorities(new HashSet<>(authorityRepository.findAll()));

        // Save user
        userRepository.save(user);

        return password;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
