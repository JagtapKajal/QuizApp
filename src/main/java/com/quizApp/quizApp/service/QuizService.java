package com.quizApp.quizApp.service;

import com.quizApp.quizApp.DTO.QuestionDTO;
import com.quizApp.quizApp.entity.Questions;

import java.util.List;

public interface QuizService {

    // to get random questions
    String createQuiz(String quizname, int noOfQuestions, String category);

    // Method to get quiz questions
    List<QuestionDTO> getQuizQuestion(int id);


}
