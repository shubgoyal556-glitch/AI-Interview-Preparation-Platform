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
        model.addAttribute(
                "questionCount",
                questionService.getQuestionCount("Java")
        );

        return "java";
    }
        @GetMapping("/dsa")
        public String dsaQuestions(Model model) {

            model.addAttribute(
                    "questions",
                    questionService.getQuestionsByCategory("DSA")
            );

            return "dsa";
        }

        @GetMapping("/dbms")
        public String dbmsQuestions(Model model) {

            model.addAttribute(
                    "questions",
                    questionService.getQuestionsByCategory("DBMS")
            );

            return "dbms";
        }

        @GetMapping("/os")
        public String osQuestions(Model model) {

            model.addAttribute(
                    "questions",
                    questionService.getQuestionsByCategory("OS")
            );

            return "os";
        }

        @GetMapping("/oops")
        public String oopsQuestions(Model model) {

            model.addAttribute(
                    "questions",
                    questionService.getQuestionsByCategory("OOPs")
            );

            return "oops";
        }
    }
