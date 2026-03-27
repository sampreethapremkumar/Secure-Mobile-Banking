package com.banking.service.impl;

import com.banking.dto.UserDto;
import com.banking.entity.User;
import com.banking.repository.UserRepository;
import com.banking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * User Service Implementation
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public UserDto registerUser(UserDto userDto) {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setFullName(userDto.getFullName());
        user.setPhone(userDto.getPhone());
        user.setRole(User.Role.USER);
        
        User savedUser = userRepository.save(user);
        return new UserDto(savedUser);
    }
    
    @Override
    public UserDto loginUser(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        
        return new UserDto(user);
    }
    
    @Override
    public UserDto getUserById(Long id) {
        User user = findUserEntityById(id);
        return new UserDto(user);
    }
    
    @Override
    public UserDto getUserByUsername(String username) {
        User user = findUserEntityByUsername(username);
        return new UserDto(user);
    }
    
    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new UserDto(user);
    }
    
    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = findUserEntityById(id);
        
        user.setFullName(userDto.getFullName());
        user.setPhone(userDto.getPhone());
        
        User updatedUser = userRepository.save(user);
        return new UserDto(updatedUser);
    }
    
    @Override
    public void deleteUser(Long id) {
        User user = findUserEntityById(id);
        userRepository.delete(user);
    }
    
    @Override
    public User findUserEntityById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    
    @Override
    public User findUserEntityByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}