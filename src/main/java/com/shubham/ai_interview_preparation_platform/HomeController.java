package com.shubham.ai_interview_preparation_platform;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/subjects")
    public String subjectsPage() {
        return "subjects";
    }

}