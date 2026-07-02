package com.shubham.ai_interview_preparation_platform.repository;

import com.shubham.ai_interview_preparation_platform.entity.CompletedQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompletedQuestionRepository extends JpaRepository<CompletedQuestion, Long> {

    long countByUserId(Long userId);

    boolean existsByUserIdAndQuestionId(Long userId, Long questionId);

    @Query(value = """
    SELECT COUNT(*)
    FROM completed_questions cq
    JOIN questions q
    ON cq.question_id = q.id
    WHERE cq.user_id = :userId
    AND q.category = :category
    """, nativeQuery = true)
    long countCompletedByUserAndCategory(
            @Param("userId") Long userId,
            @Param("category") String category
    );
}