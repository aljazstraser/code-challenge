package com.code.challenge.code.challenge.constants;

public final class QuestionsAndAnswersConstants {

    public static final int MAX_LENGTH = 255;
    public static final String ANSWER_TO_LIFE = "The answer to life, universe and everything is 42";
    public static final String INVALID_INPUT_FORMAT_QUESTION = "Invalid input format. Please follow <question>?";
    public static final String QA_ADDED = "Question and answers added successfully.";
    public static final String QUESTION_ADD_EXISTS = "Question already exists.";
    public static final String INVALID_INPUT_FORMAT_QUESTION_ANSWER = "Invalid input format. Please follow <question>? \"<answer1>\" \"<answer2>\" ...";

    public static final String ANSWER_LENGTH_NOT_VALID = String.format("Answer length should not exceed %d characters.",MAX_LENGTH);
    public static final String QUESTION_LENGTH_NOT_VALID = String.format("Question length should not exceed %d characters.",MAX_LENGTH);
}
