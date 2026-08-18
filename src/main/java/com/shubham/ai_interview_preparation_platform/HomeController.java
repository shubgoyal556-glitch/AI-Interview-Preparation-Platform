package com.shubham.ai_interview_preparation_platform;

import com.shubham.ai_interview_preparation_platform.service.ProgressService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ProgressService progressService;

    @GetMapping("/")
    public String home() {
        return "index";
    }
}