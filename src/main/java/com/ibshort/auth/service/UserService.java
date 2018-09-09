package com.ibshort.auth.service;

import com.ibshort.auth.model.User;

public interface UserService {

    String save(User user);

    User findByUsername(String username);
}
