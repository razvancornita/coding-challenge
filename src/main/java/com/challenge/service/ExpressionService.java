package com.challenge.service;

import com.challenge.util.ValidatorUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ExpressionService {

    private final DecimalFormat resultFormat = new DecimalFormat("0.00");

    public String processExpression(String expression) {
        Optional<String> result = evaluateExpression(expression);
        if (result.isPresent()) {
            return String.valueOf(result.get());
        } else {
            return "error";
        }
    }

    private Optional<String> evaluateExpression(String expression) {
        List<String> formattedExpression = formatExpression(expression);
        if (!ValidatorUtil.checkIfExpressionIsValid(formattedExpression)) {
            return Optional.empty();
        }

        return Optional.of(performEvaluation(formattedExpression));
    }


    private List<String> formatExpression(String line) {
        List<String> list = new ArrayList<>();
        String[] tokens = line.split(" ");
        Collections.addAll(list, tokens);
        Collections.reverse(list);
        return list;
    }

    private void performOperation(Deque<Double> numbers, String token) {
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

    private String performEvaluation(List<String> formattedExpression) {
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
