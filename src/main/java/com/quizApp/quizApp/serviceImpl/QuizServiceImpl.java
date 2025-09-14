package com.quizApp.quizApp.serviceImpl;

import com.quizApp.quizApp.DTO.QuestionDTO;
import com.quizApp.quizApp.entity.Questions;
import com.quizApp.quizApp.entity.Quiz;
import com.quizApp.quizApp.repository.QuestionsRepository;
import com.quizApp.quizApp.repository.QuizRepository;
import com.quizApp.quizApp.request.QuizRequest;
import com.quizApp.quizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionsRepository questionsRepository;

    // Method to create Quiz
    @Override
    public String createQuiz(String quizname, int noOfQuestions, String category) {

        Quiz quiz = new Quiz();
        quiz.setQuiztitle(quizname);
        List<Questions> questionsList = quizRepository.findRandomQuestions(noOfQuestions, category);
        quiz.setQuestionsList(questionsList);
        quizRepository.save(quiz);
        String msg = "Your Quiz is Created..";
        return msg;
    }


    // Method to get Quiz questions
    @Override
    public List<QuestionDTO> getQuizQuestion(int id) {

        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found" +id));
        List<Questions> questionsList = quiz.getQuestionsList();
        List<QuestionDTO> questionDTOS = new ArrayList<>();

        for (Questions q : questionsList) {
            QuestionDTO dto = new QuestionDTO(q.getId(), q.getQuestion(), q.getOption1(),
                    q.getOption2(), q.getOption3(), q.getOption4());
            questionDTOS.add(dto);
        }
        return questionDTOS;
    }

    // Method to submit quiz with quiz id and options
    @Override
    public String submitQuiz(List<QuizRequest> requests, int quizId) {
        Quiz quiz = quizRepository.findById(quizId).get();
        List<Questions> questionListOfQuiz = quiz.getQuestionsList();
        int correctAnswer = 0;
        for (Questions q : questionListOfQuiz) {
            for (QuizRequest quizRequest : requests) {
                if (quizRequest.getQid() == q.getId()) {
                    if (quizRequest.getOptionList() == q.getCorrect_option()) {
                        correctAnswer++;
                    }
                } else {
                    //question is not from Quiz
                }
            }
        }

        String msg = "Your score is : " + correctAnswer;
        return msg;
        }

}