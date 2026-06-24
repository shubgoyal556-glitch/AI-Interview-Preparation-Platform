package com.shubham.ai_interview_preparation_platform.repository;

import com.shubham.ai_interview_preparation_platform.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByCategory(String category);

}