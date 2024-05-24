package com.code.challenge.code.challenge.runner;

import com.code.challenge.code.challenge.service.IQuestionsAndAnswers;
import com.code.challenge.code.challenge.service.impl.QuestionsAndAnswers;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class QuestionsAndAnswersRunner implements CommandLineRunner {

    private final IQuestionsAndAnswers questionsAndAnswers;

    private QuestionsAndAnswersRunner(QuestionsAndAnswers questionsAndAnswers) {
        this.questionsAndAnswers = questionsAndAnswers;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Question-Answer Application!");
        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. Ask a Question");
            System.out.println("2. Add/Update a Question and Answer(s)");
            System.out.println("3. Exit");
            String option = scanner.nextLine().trim();

            switch (option) {
                case "1":
                    questionsAndAnswers.askQuestion(scanner.nextLine().trim());
                    break;
                case "2":
                    questionsAndAnswers.addQuestionAndAnswers(scanner.nextLine().trim());
                    break;
                case "3":
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");

            }

        }

    }


}