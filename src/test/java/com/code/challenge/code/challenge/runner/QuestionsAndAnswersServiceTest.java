package com.code.challenge.code.challenge.runner;

import com.code.challenge.code.challenge.service.IQuestionsAndAnswers;
import com.code.challenge.code.challenge.service.impl.QuestionsAndAnswers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionsAndAnswersServiceTest {

    private IQuestionsAndAnswers service;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        service = new QuestionsAndAnswers();
        System.setOut(new PrintStream(outputStreamCaptor));
        service.deleteQuestionAndAnswers();
    }

    @Test
    void askQuestionWithValidQuestion() {
        String question = "What is Java?";
        service.addQuestionAndAnswers("What is Java? \"A programming language\" \"A coffee type\"");
        assertEquals("Question and answers added successfully." + System.lineSeparator(), outputStreamCaptor.toString());
        outputStreamCaptor.reset();
        service.askQuestion(question);
        assertEquals("A programming language" + System.lineSeparator() + "A coffee type" + System.lineSeparator(), outputStreamCaptor.toString());
    }

    @Test
    void askQuestionWithInvalidFormat() {
        service.askQuestion("What is Java");
        assertEquals("Invalid input format. Please follow <question>?" + System.lineSeparator(), outputStreamCaptor.toString());
    }

    @Test
    void askQuestionWithUnknownQuestion() {
        service.askQuestion("What is the answer to life?");
        assertEquals("The answer to life, universe and everything is 42" + System.lineSeparator(), outputStreamCaptor.toString());
    }

    @Test
    void addQuestionAndAnswersWithInvalidFormat() {
        service.addQuestionAndAnswers("What is Java \"A programming language\"");
        assertEquals("Invalid input format. Please follow <question>? \"<answer1>\" \"<answer2>\" ..." + System.lineSeparator(), outputStreamCaptor.toString());
    }

    @Test
    void addQuestionAndAnswersWithExceedingQuestionLength() {
        String longQuestion = "A".repeat(256) + "? \"Answer\"";
        service.addQuestionAndAnswers(longQuestion);
        assertEquals("Question length should not exceed 255 characters." + System.lineSeparator(), outputStreamCaptor.toString());
    }

    @Test
    void addQuestionAndAnswersWithValidInput() {
        service.addQuestionAndAnswers("What is Java? \"A programming language\" \"A coffee type\"");
        assertEquals("Question and answers added successfully." + System.lineSeparator(), outputStreamCaptor.toString());
        outputStreamCaptor.reset();
        service.askQuestion("What is Java?");
        assertEquals("A programming language" + System.lineSeparator() + "A coffee type" + System.lineSeparator(), outputStreamCaptor.toString());
    }


    @Test
    void addQuestionAndAnswersWithInvalidAnswer() {
        service.addQuestionAndAnswers("What is Java? \"\"");
        assertEquals("Invalid input format. Please follow <question>? \"<answer1>\" \"<answer2>\" ..." + System.lineSeparator(), outputStreamCaptor.toString());
    }

    @Test
    void addQuestionAndAnswersWithExceedingAnswerLength() {
        String longAnswer = "A".repeat(256);
        service.addQuestionAndAnswers("What is Java? \"" + longAnswer + "\"");
        assertEquals("Answer length should not exceed 255 characters." + System.lineSeparator(), outputStreamCaptor.toString());
    }

}