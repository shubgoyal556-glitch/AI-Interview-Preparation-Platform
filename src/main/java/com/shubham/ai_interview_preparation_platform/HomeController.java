package com.shubham.ai_interview_preparation_platform;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.shubham.ai_interview_preparation_platform.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/student-dashboard")
    public String studentDashboard(Model model) {

        model.addAttribute("javaProgress", progressService.getProgress(1L, "Java"));
        model.addAttribute("dsaProgress", progressService.getProgress(1L, "DSA"));
        model.addAttribute("dbmsProgress", progressService.getProgress(1L, "DBMS"));
        model.addAttribute("osProgress", progressService.getProgress(1L, "OS"));
        model.addAttribute("oopsProgress", progressService.getProgress(1L, "OOPs"));

        return "student-dashboard";
    }
    @Autowired
    private ProgressService progressService;

   

}