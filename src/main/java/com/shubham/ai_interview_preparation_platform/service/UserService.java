package com.shubham.ai_interview_preparation_platform.service;

import com.shubham.ai_interview_preparation_platform.entity.User;
import com.shubham.ai_interview_preparation_platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // NEW METHOD
    public boolean loginUser(String email, String password) {

        Optional<User> user = userRepository.findByEmail(email);

        if(user.isPresent()) {
            return user.get().getPassword().equals(password);
        }

        return false;
    }
}