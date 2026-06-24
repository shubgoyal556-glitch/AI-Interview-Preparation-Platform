package com.shubham.ai_interview_preparation_platform;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
   }
    @GetMapping("/java")
    public String javaPage() {
        return "java";
    }

    @GetMapping("/dsa")
    public String dsaPage() {
        return "dsa";
    }

    @GetMapping("/dbms")
    public String dbmsPage() {
        return "dbms";
    }

    @GetMapping("/os")
    public String osPage() {
        return "os";
    }

    @GetMapping("/oops")
    public String oopsPage() {
        return "oops";
    }
}