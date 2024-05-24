package com.code.challenge.code.challenge.utils;

import static com.code.challenge.code.challenge.constants.QuestionsAndAnswersConstants.*;

public class QuestionsAndAnswersPrintUtils {

    public static void printInvalidFormatError() {
        System.out.println(INVALID_INPUT_FORMAT_QUESTION_ANSWER);
    }

    public static void printAnswerLengthExceededError() {
        System.out.println(ANSWER_LENGTH_NOT_VALID);
    }

    public static void printQuestionLengthExceededError() {
        System.out.println(QUESTION_LENGTH_NOT_VALID);
    }

    public static void printInvalidFormatQuestionError() {
        System.out.println(INVALID_INPUT_FORMAT_QUESTION);
    }

    public static void printQuestionExistsError() {
        System.out.println(QUESTION_ADD_EXISTS);
    }

    public static void printQuestionAdded() {
        System.out.println(QA_ADDED);
    }


}
