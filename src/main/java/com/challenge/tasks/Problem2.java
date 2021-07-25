package com.challenge.tasks;

import com.challenge.util.ScannerUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Problem2 {

    private static final DecimalFormat resultFormat = new DecimalFormat("0.00");
    private static final List<String> validOperators = Arrays.asList("+", "-", "*", "/");

    public static void main(String[] args) {
        List<String> expressions = ScannerUtil.readExpressions();
        expressions.forEach(expression -> processExpression(expression));
    }

    private static void processExpression(String expression) {
        Optional<String> result = evaluateExpression(expression);
        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("error");
        }
    }

    private static Optional<String> evaluateExpression(String expression) {
        List<String> formattedExpression = formatExpression(expression);
        if (!checkIfExpressionIsValid(formattedExpression)) {
            return Optional.empty();
        }

        return Optional.of(performEvaluation(formattedExpression));
    }


    public static List<String> formatExpression(String line) {
        List<String> list = new ArrayList<>();
        String[] tokens = line.split(" ");
        Collections.addAll(list, tokens);
        Collections.reverse(list);
        return list;
    }

    private static boolean checkIfExpressionIsValid(List<String> formattedExpression) {
        int numDigits = 0;
        int numOperators = 0;

        for (String token : formattedExpression) {
            try {
                Double.parseDouble(token);
                numDigits++;
            } catch (NumberFormatException e) {
                if (validOperators.contains(token)) {
                    numOperators++;
                } else {
                    return false;
                }
            }
        }
        return numDigits - numOperators == 1;
    }

    private static void performOperation(Deque<Double> numbers, String token) {
        switch (token) {
            case "+":
                numbers.push(numbers.pop() + numbers.pop());
                break;
            case "-":
                numbers.push(numbers.pop() - numbers.pop());
                break;
            case "*":
                numbers.push(numbers.pop() * numbers.pop());
                break;
            case "/":
                numbers.push(numbers.pop() / numbers.pop());
        }
    }

    private static String performEvaluation(List<String> formattedExpression) {
        Deque<Double> numbers = new LinkedList<>();
        for (String token : formattedExpression) {
            try {
                numbers.push(Double.parseDouble(token));
            } catch (NumberFormatException e) {
                performOperation(numbers, token);
            }
        }
        return resultFormat.format(numbers.pop());
    }
}
