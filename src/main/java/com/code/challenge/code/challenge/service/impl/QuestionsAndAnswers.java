package com.code.challenge.code.challenge.service.impl;

import com.code.challenge.code.challenge.service.IQuestionsAndAnswers;
import com.code.challenge.code.challenge.utils.QuestionsAndAnswersPrintUtils;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.code.challenge.code.challenge.constants.QuestionsAndAnswersConstants.ANSWER_TO_LIFE;
import static com.code.challenge.code.challenge.constants.QuestionsAndAnswersConstants.MAX_LENGTH;
import static com.code.challenge.code.challenge.utils.QuestionsAndAnswersPrintUtils.*;
import static com.code.challenge.code.challenge.utils.QuestionsAndAnswersUtils.formatQuestion;
import static com.code.challenge.code.challenge.utils.QuestionsAndAnswersUtils.parseAnswers;

@Service
public class QuestionsAndAnswers implements IQuestionsAndAnswers {

    public static final Map<String, List<String>> questionAnswerMap = new HashMap<>();

    @Override
    public void askQuestion(String question) {
        Optional<String> formattedQuestion = formatQuestion(question);

        if (formattedQuestion.isEmpty()) {
            printInvalidFormatQuestionError();
            return;
        }

        List<String> answers = questionAnswerMap.getOrDefault(formattedQuestion.get(), Collections.singletonList(ANSWER_TO_LIFE));
        answers.forEach(System.out::println);
    }

    @Override
    public void addQuestionAndAnswers(String input) {
        Optional<String> formattedQuestion = formatQuestion(input);
        if (formattedQuestion.isEmpty()) {
            printInvalidFormatError();
            return;
        } else if (formattedQuestion.get().length() > MAX_LENGTH) {
            printQuestionLengthExceededError();
            return;
        }

        String answersString = input.substring(formattedQuestion.get().length()).trim();
        List<String> answers = parseAnswers(answersString);
        if (answers == null) {
            printInvalidFormatError();
            return;
        } else if (answers.stream().anyMatch(a -> a.length() > MAX_LENGTH)) {
            printAnswerLengthExceededError();
            return;
        }

        questionAnswerMap.compute(formattedQuestion.get(), (k, v) -> {
            if (v != null) {
                QuestionsAndAnswersPrintUtils.printQuestionExistsError();
                return v;
            } else {
                QuestionsAndAnswersPrintUtils.printQuestionAdded();
                return answers;
            }
        });
    }


    @Override
    public void deleteQuestionAndAnswers() {
        questionAnswerMap.clear();
    }


}
