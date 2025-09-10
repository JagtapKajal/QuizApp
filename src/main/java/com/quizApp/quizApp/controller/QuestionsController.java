package com.quizApp.quizApp.controller;

import com.quizApp.quizApp.entity.Questions;
import com.quizApp.quizApp.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionsController {

    @Autowired
    private QuestionsService quizService;

    @GetMapping("/getALlQues")
    public ResponseEntity<List<Questions>> getAllQuestions(){
        List<Questions> questionsList = quizService.getAllQuestions();
        return new ResponseEntity<>(questionsList, HttpStatus.OK);
    }
}
