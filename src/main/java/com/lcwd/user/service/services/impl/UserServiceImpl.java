package com.lcwd.user.service.services.impl;

import com.lcwd.user.service.Entities.User;
import com.lcwd.user.service.exceptions.DuplicateResourceException;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User savedUser(User user) {

        if (userRepository.existsByNameAndEmail(user.getName(), user.getEmail())) {
            throw new DuplicateResourceException("USER with same name and email already exists!");
        }
        String randomId = UUID.randomUUID().toString();
        user.setUserId(randomId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow
                (()-> new ResourceNotFoundException("User with given Id not found on server0"));
    }

    @Override
    public User deleteUserById(String userId) {
        User user =userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        userRepository.delete(user);
        return user;
    }
}
