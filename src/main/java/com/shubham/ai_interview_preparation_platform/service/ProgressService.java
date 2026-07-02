package com.shubham.ai_interview_preparation_platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgressService {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CompletedQuestionService completedQuestionService;

    public int getProgress(Long userId, String category) {

        long total = questionService.getQuestionCount(category);

        long completed = completedQuestionService.getCompletedByCategory(userId, category);

        if (total == 0) {
            return 0;
        }

        return (int) ((completed * 100) / total);

    }
}