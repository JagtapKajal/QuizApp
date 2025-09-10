package com.quizApp.quizApp.repository;

import com.quizApp.quizApp.entity.Questions;
import com.quizApp.quizApp.entity.Quiz;
import com.quizApp.quizApp.service.QuizService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {


    // sql query to get random questions
    @Query(value = "Select * from questions q where q.category= :category ORDER BY RAND() LIMIT :noOfQuestions ", nativeQuery = true)
    List<Questions> findRandomQuestions(@Param("noOfQuestions") int noOfQuestions, @Param("category") String category);
}
