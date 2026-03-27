package com.banking.service;

import com.banking.dto.UserDto;
import com.banking.entity.User;

/**
 * User Service interface
 */
public interface UserService {
    
    UserDto registerUser(UserDto userDto);
    
    UserDto loginUser(String email, String password);
    
    UserDto getUserById(Long id);
    
    UserDto getUserByUsername(String username);
    
    UserDto getUserByEmail(String email);
    
    UserDto updateUser(Long id, UserDto userDto);
    
    void deleteUser(Long id);
    
    User findUserEntityById(Long id);
    
    User findUserEntityByUsername(String username);
}