package com.shubham.ai_interview_preparation_platform.service;

import com.shubham.ai_interview_preparation_platform.entity.Question;
import com.shubham.ai_interview_preparation_platform.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {

        List<Question> questions = questionRepository.findByCategory(category);

        System.out.println("Category = " + category);
        System.out.println("Questions found = " + questions.size());

        return questions;
    }
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }
}