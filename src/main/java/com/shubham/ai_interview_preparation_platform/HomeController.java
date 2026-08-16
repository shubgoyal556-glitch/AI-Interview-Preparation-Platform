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

    @GetMapping("/student-dashboard")
    public String studentDashboard(
            Model model,
            HttpSession session) {

        Long userId = (Long) session.getAttribute("userId");
        String userName = (String) session.getAttribute("userName");

        if (userId == null) {
            return "redirect:/login";
        }

        int javaProgress = progressService.getProgress(userId, "Java");
        int dsaProgress = progressService.getProgress(userId, "DSA");
        int dbmsProgress = progressService.getProgress(userId, "DBMS");
        int osProgress = progressService.getProgress(userId, "OS");
        int oopsProgress = progressService.getProgress(userId, "OOPs");

        int overallProgress =
                (javaProgress + dsaProgress + dbmsProgress + osProgress + oopsProgress) / 5;

        model.addAttribute("userName", userName);

        model.addAttribute("javaProgress", javaProgress);
        model.addAttribute("dsaProgress", dsaProgress);
        model.addAttribute("dbmsProgress", dbmsProgress);
        model.addAttribute("osProgress", osProgress);
        model.addAttribute("oopsProgress", oopsProgress);

        model.addAttribute("overallProgress", overallProgress);

        return "student-dashboard";
    }
}