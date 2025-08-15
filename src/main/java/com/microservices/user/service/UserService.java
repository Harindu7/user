package com.microservices.user.service;

import com.microservices.user.model.dto.UserDTO;
import com.microservices.user.model.entity.User;

import java.util.List;

public interface UserService {
    User createUser(UserDTO userDTO);
    User updateUser(String id, UserDTO userDTO);
    List<User> getAllUsers();
    User deactivateUser(String id);
    User getUserById(String id);
}
