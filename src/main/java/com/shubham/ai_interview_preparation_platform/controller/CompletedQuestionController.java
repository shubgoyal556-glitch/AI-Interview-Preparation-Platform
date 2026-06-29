package com.shubham.ai_interview_preparation_platform.controller;

import com.shubham.ai_interview_preparation_platform.entity.CompletedQuestion;
import com.shubham.ai_interview_preparation_platform.service.CompletedQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CompletedQuestionController {

    @Autowired
    private CompletedQuestionService completedQuestionService;

    @PostMapping("/complete-question")
    public String completeQuestion(@RequestParam Long questionId) {

        CompletedQuestion completedQuestion = new CompletedQuestion();

        // Temporary user ID
        completedQuestion.setUserId(1L);

        completedQuestion.setQuestionId(questionId);

        if(!completedQuestionService.isCompleted(1L, questionId)){

            completedQuestionService.save(completedQuestion);

        }
        return "redirect:/java";
    }
}