package com.lcwd.user.service.services;

import com.lcwd.user.service.Entities.User;

import java.util.List;

public interface UserService {

    User savedUser(User user);

    List<User> getAllUsers();

    User getUser(String userId);
    User deleteUserById(String userId);


}
