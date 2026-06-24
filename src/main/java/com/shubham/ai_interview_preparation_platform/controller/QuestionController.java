package com.shubham.ai_interview_preparation_platform.controller;

import com.shubham.ai_interview_preparation_platform.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/java")
    public String javaQuestions(Model model) {

        model.addAttribute(
                "questions",
                questionService.getQuestionsByCategory("Java")
        );

        return "java";
    }
}