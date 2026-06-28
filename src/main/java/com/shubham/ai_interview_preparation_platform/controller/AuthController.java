package com.shubham.ai_interview_preparation_platform.controller;

import com.shubham.ai_interview_preparation_platform.entity.User;
import com.shubham.ai_interview_preparation_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {

        userService.registerUser(user);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(
            @RequestParam String email,
            @RequestParam String password,
            Model model) {

        boolean success = userService.loginUser(email, password);

        if(success) {
            return "redirect:/student-dashboard";
        }

        model.addAttribute("error", "Invalid Email or Password");

        return "login";
    }

}