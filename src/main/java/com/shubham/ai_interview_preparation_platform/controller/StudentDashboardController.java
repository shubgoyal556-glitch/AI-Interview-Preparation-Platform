package com.shubham.ai_interview_preparation_platform.controller;

import com.shubham.ai_interview_preparation_platform.service.CompletedQuestionService;
import com.shubham.ai_interview_preparation_platform.service.QuestionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentDashboardController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CompletedQuestionService completedQuestionService;

    @GetMapping("/student-dashboard")
    public String studentDashboard(Model model, HttpSession session) {

        // Get logged-in user
        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/login";
        }

        // User name
        String userName = (String) session.getAttribute("userName");

        if (userName == null) {
            userName = "Student";
        }

        model.addAttribute("userName", userName);


        // Java
        long javaTotal = questionService.getQuestionCount("Java");
        long javaCompleted =
                completedQuestionService.getCompletedByCategory(userId, "Java");

        int javaProgress = calculateProgress(javaCompleted, javaTotal);

        model.addAttribute("javaProgress", javaProgress);


        // DSA
        long dsaTotal = questionService.getQuestionCount("DSA");
        long dsaCompleted =
                completedQuestionService.getCompletedByCategory(userId, "DSA");

        int dsaProgress = calculateProgress(dsaCompleted, dsaTotal);

        model.addAttribute("dsaProgress", dsaProgress);


        // DBMS
        long dbmsTotal = questionService.getQuestionCount("DBMS");
        long dbmsCompleted =
                completedQuestionService.getCompletedByCategory(userId, "DBMS");

        int dbmsProgress = calculateProgress(dbmsCompleted, dbmsTotal);

        model.addAttribute("dbmsProgress", dbmsProgress);


        // OS
        long osTotal = questionService.getQuestionCount("OS");
        long osCompleted =
                completedQuestionService.getCompletedByCategory(userId, "OS");

        int osProgress = calculateProgress(osCompleted, osTotal);

        model.addAttribute("osProgress", osProgress);


        // OOPs
        long oopsTotal = questionService.getQuestionCount("OOPs");
        long oopsCompleted =
                completedQuestionService.getCompletedByCategory(userId, "OOPs");

        int oopsProgress = calculateProgress(oopsCompleted, oopsTotal);

        model.addAttribute("oopsProgress", oopsProgress);


        // Overall progress
        long totalQuestions =
                javaTotal + dsaTotal + dbmsTotal + osTotal + oopsTotal;

        long totalCompleted =
                javaCompleted + dsaCompleted + dbmsCompleted
                        + osCompleted + oopsCompleted;

        int overallProgress =
                calculateProgress(totalCompleted, totalQuestions);

        model.addAttribute("overallProgress", overallProgress);


        return "student-dashboard";
    }


    private int calculateProgress(long completed, long total) {

        if (total == 0) {
            return 0;
        }

        return (int) ((completed * 100) / total);
    }
}