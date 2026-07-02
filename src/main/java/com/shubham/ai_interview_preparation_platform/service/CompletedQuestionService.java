package com.shubham.ai_interview_preparation_platform.service;

import com.shubham.ai_interview_preparation_platform.entity.CompletedQuestion;
import com.shubham.ai_interview_preparation_platform.repository.CompletedQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompletedQuestionService {

    @Autowired
    private CompletedQuestionRepository repository;

    public CompletedQuestion save(CompletedQuestion completedQuestion) {

        return repository.save(completedQuestion);

    }

    public boolean isCompleted(Long userId, Long questionId){

        return repository.existsByUserIdAndQuestionId(userId, questionId);

    }

    public long completedCount(Long userId){

        return repository.countByUserId(userId);

    }
    public long getCompletedQuestionCount(Long userId) {

        return repository.countByUserId(userId);

    }
    public void markCompleted(Long userId, Long questionId) {

        if (!repository.existsByUserIdAndQuestionId(userId, questionId)) {

            CompletedQuestion completedQuestion = new CompletedQuestion();

            completedQuestion.setUserId(userId);
            completedQuestion.setQuestionId(questionId);

            repository.save(completedQuestion);
        }
    }
    public long getCompletedByCategory(Long userId, String category) {

        return repository.countCompletedByUserAndCategory(userId, category);

    }

}