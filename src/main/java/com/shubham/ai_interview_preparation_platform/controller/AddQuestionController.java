package com.shubham.ai_interview_preparation_platform.controller;

import com.shubham.ai_interview_preparation_platform.entity.Question;
import com.shubham.ai_interview_preparation_platform.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddQuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/add-question")
    public String showForm() {
        return "add-question";
    }

    @PostMapping("/save-question")
    public String saveQuestion(@ModelAttribute Question question) {

        questionService.saveQuestion(question);

        return "redirect:/java";
    }
}