package com.code.challenge.code.challenge.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class QuestionsAndAnswersUtils {

    public static List<String> parseAnswers(String answersString) {
        if (!answersString.matches("(\"[^\"]+\"\\s*)+")) {
            return null;
        }
        return Arrays.stream(answersString.split("\\s\"|\"\\s"))
                .map(a -> a.replaceAll("\"", "").trim())
                .collect(Collectors.toList());
    }

    public static Optional<String> formatQuestion(String input) {
        if (input == null || input.indexOf('?') == -1) {
            return Optional.empty();
        }
        return Optional.of(input.substring(0, input.indexOf('?') + 1).trim());
    }


}
