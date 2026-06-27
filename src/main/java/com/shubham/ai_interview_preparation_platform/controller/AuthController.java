package com.shubham.ai_interview_preparation_platform.controller;
import com.shubham.ai_interview_preparation_platform.entity.User;
import com.shubham.ai_interview_preparation_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

}