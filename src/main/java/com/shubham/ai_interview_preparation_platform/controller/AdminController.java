package com.shubham.ai_interview_preparation_platform.controller;

import com.shubham.ai_interview_preparation_platform.entity.Question;
import com.shubham.ai_interview_preparation_platform.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AdminController {

    @GetMapping("/admin-dashboard")
    public String adminDashboard() {

        return "admin-dashboard";

    }
    @Autowired
    private QuestionService questionService;
    @GetMapping("/admin/questions")
    public String viewQuestions(Model model) {

        model.addAttribute(
                "questions",
                questionService.getAllQuestions()
        );

        return "admin-questions";
    }
    @GetMapping("/admin/delete-question/{id}")
    public String deleteQuestion(@PathVariable Long id) {

        questionService.deleteQuestion(id);

        return "redirect:/admin/questions";

    }
    @GetMapping("/admin/edit-question/{id}")
    public String editQuestion(@PathVariable Long id, Model model) {

        model.addAttribute(
                "question",
                questionService.getQuestionById(id)
        );

        return "edit-question";
    }
    @PostMapping("/admin/update-question")
    public String updateQuestion(@ModelAttribute Question question) {

        questionService.saveQuestion(question);

        return "redirect:/admin/questions";

    }
    @GetMapping("/admin/add-question")
    public String addQuestionPage(Model model){

        model.addAttribute("question", new Question());

        return "add-question";

    }
    @PostMapping("/admin/save-question")
    public String saveQuestion(@ModelAttribute Question question){

        questionService.saveQuestion(question);

        return "redirect:/admin/questions";

    }

}