package com.trabajo.demo.application.service;

import java.util.List;

import com.trabajo.demo.domain.User;
import com.trabajo.demo.domain.dto.UserRequest;

public interface UserService {
    List<User> findAllUsers();
    Boolean newUser(UserRequest user);

    User updateUserById(UserRequest user);
}
