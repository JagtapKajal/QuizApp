package com.quizApp.quizApp.controller;

import com.quizApp.quizApp.DTO.QuestionDTO;
import com.quizApp.quizApp.request.QuizRequest;
import com.quizApp.quizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {

    @Autowired
    private QuizService quizService;

    // API To create Quiz
    @PostMapping("/CreateQuiz")
    public ResponseEntity<String> createQuiz(@RequestParam int noOfQuestions,
                                             @RequestParam String quizname,
                                             @RequestParam String category){

        String msg = quizService.createQuiz(quizname,noOfQuestions,category);
        return new ResponseEntity<>(msg , HttpStatus.CREATED);
    }

    // API To get Quiz questions
    @GetMapping("/getQuiz/{id}")
    public ResponseEntity<List<QuestionDTO>> getQuizQuestions(@PathVariable("id") int id){
        List<QuestionDTO> questionlist = quizService.getQuizQuestion(id);
        return new ResponseEntity<>(questionlist,HttpStatus.OK);
    }

    // API to submit quiz
    @PostMapping("/submit/{id}")
    public ResponseEntity<String> submitQuiz(@RequestBody List<QuizRequest> requests ,@PathVariable("id") int quizId){
    String msg = quizService.submitQuiz(requests,quizId);
    return new ResponseEntity<>(msg, HttpStatus.OK);
    }


}
