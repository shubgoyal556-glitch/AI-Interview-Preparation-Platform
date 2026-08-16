package com.shubham.ai_interview_preparation_platform.controller;

import com.shubham.ai_interview_preparation_platform.entity.CompletedQuestion;
import com.shubham.ai_interview_preparation_platform.entity.Question;
import com.shubham.ai_interview_preparation_platform.service.CompletedQuestionService;
import com.shubham.ai_interview_preparation_platform.service.QuestionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CompletedQuestionController {

    @Autowired
    private CompletedQuestionService completedQuestionService;

    @Autowired
    private QuestionService questionService;

    @PostMapping("/complete-question")
    public String completeQuestion(
            @RequestParam Long questionId,
            HttpSession session) {

        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/login";
        }

        // Mark question as completed
        if (!completedQuestionService.isCompleted(userId, questionId)) {

            CompletedQuestion completedQuestion = new CompletedQuestion();

            completedQuestion.setUserId(userId);
            completedQuestion.setQuestionId(questionId);

            completedQuestionService.save(completedQuestion);
        }

        // Find the question's category
        Question question = questionService.getQuestionById(questionId);

        if (question == null) {
            return "redirect:/student-dashboard";
        }

        String category = question.getCategory();

        // Redirect to the correct subject page
        switch (category) {

            case "Java":
                return "redirect:/java";

            case "DSA":
                return "redirect:/dsa";

            case "DBMS":
                return "redirect:/dbms";

            case "OS":
                return "redirect:/os";

            case "OOPs":
                return "redirect:/oops";

            default:
                return "redirect:/student-dashboard";
        }
    }
}