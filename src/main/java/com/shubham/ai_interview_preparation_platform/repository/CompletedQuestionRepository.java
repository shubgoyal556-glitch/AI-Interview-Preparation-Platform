package com.shubham.ai_interview_preparation_platform.repository;

import com.shubham.ai_interview_preparation_platform.entity.CompletedQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompletedQuestionRepository
        extends JpaRepository<CompletedQuestion, Long> {

    long countByUserId(Long userId);

    boolean existsByUserIdAndQuestionId(Long userId, Long questionId);

}