package com.quizApp.quizApp.repository;

import com.quizApp.quizApp.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository extends JpaRepository<Questions, Integer> {
}
