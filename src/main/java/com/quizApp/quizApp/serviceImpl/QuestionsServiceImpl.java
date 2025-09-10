package com.quizApp.quizApp.serviceImpl;

import com.quizApp.quizApp.entity.Questions;
import com.quizApp.quizApp.repository.QuestionsRepository;
import com.quizApp.quizApp.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    private QuestionsRepository quizRepository;


    @Override
    public List<Questions> getAllQuestions() {
        List<Questions> questionList = quizRepository.findAll();
        return questionList;
    }
}
