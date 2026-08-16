package com.shubham.ai_interview_preparation_platform.controller;

import com.shubham.ai_interview_preparation_platform.service.CompletedQuestionService;
import com.shubham.ai_interview_preparation_platform.service.QuestionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CompletedQuestionService completedQuestionService;


    @GetMapping("/java")
    public String javaQuestions(Model model, HttpSession session) {

        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/login";
        }

        var questions = questionService.getQuestionsByCategory("Java");

        model.addAttribute("questions", questions);

        model.addAttribute(
                "questionCount",
                questionService.getQuestionCount("Java")
        );

        Set<Long> completedQuestionIds = new HashSet<>();

        for (var question : questions) {

            if (completedQuestionService.isQuestionCompleted(
                    userId,
                    question.getId())) {

                completedQuestionIds.add(question.getId());
            }
        }

        model.addAttribute(
                "completedQuestionIds",
                completedQuestionIds
        );

        return "java";
    }


    @GetMapping("/dsa")
    public String dsaQuestions(Model model, HttpSession session) {

        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/login";
        }

        var questions = questionService.getQuestionsByCategory("DSA");

        model.addAttribute("questions", questions);
        model.addAttribute("questionCount", questions.size());

        Set<Long> completedQuestionIds = new HashSet<>();

        for (var question : questions) {
            if (completedQuestionService.isQuestionCompleted(
                    userId, question.getId())) {
                completedQuestionIds.add(question.getId());
            }
        }

        model.addAttribute("completedQuestionIds", completedQuestionIds);

        return "dsa";
    }


    @GetMapping("/dbms")
    public String dbmsQuestions(Model model, HttpSession session) {

        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/login";
        }

        var questions = questionService.getQuestionsByCategory("DBMS");

        model.addAttribute("questions", questions);
        model.addAttribute("questionCount", questions.size());

        Set<Long> completedQuestionIds = new HashSet<>();

        for (var question : questions) {
            if (completedQuestionService.isQuestionCompleted(
                    userId, question.getId())) {
                completedQuestionIds.add(question.getId());
            }
        }

        model.addAttribute("completedQuestionIds", completedQuestionIds);

        return "dbms";
    }


    @GetMapping("/os")
    public String osQuestions(Model model, HttpSession session) {

        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/login";
        }

        var questions = questionService.getQuestionsByCategory("OS");

        model.addAttribute("questions", questions);
        model.addAttribute("questionCount", questions.size());

        Set<Long> completedQuestionIds = new HashSet<>();

        for (var question : questions) {
            if (completedQuestionService.isQuestionCompleted(
                    userId, question.getId())) {
                completedQuestionIds.add(question.getId());
            }
        }

        model.addAttribute("completedQuestionIds", completedQuestionIds);

        return "os";
    }


    @GetMapping("/oops")
    public String oopsQuestions(Model model, HttpSession session) {

        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/login";
        }

        var questions = questionService.getQuestionsByCategory("OOPs");

        model.addAttribute("questions", questions);
        model.addAttribute("questionCount", questions.size());

        Set<Long> completedQuestionIds = new HashSet<>();

        for (var question : questions) {
            if (completedQuestionService.isQuestionCompleted(
                    userId, question.getId())) {
                completedQuestionIds.add(question.getId());
            }
        }

        model.addAttribute("completedQuestionIds", completedQuestionIds);

        return "oops";
    }
}