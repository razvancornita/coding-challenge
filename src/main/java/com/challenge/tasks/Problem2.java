package com.challenge.tasks;

import com.challenge.util.ScannerUtil;
import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class Problem2 {

    private static final DecimalFormat resultFormat = new DecimalFormat("0.00");

    public static void main(String[] args) {
        List<String> expressions = ScannerUtil.readExpressions();
        expressions.forEach(Problem2::evaluateExpression);
    }

    private static void evaluateExpression(String expression) {
        List<String> formattedExpression = build(expression);
        if (!checkIfExpressionIsValid(formattedExpression)) {
            log.error("error");
            return;
        }

        double result = performEvaluation(formattedExpression);
        log.info(resultFormat.format(result));
    }


    public static List<String> build(String line) {
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
                if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
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

    private static double performEvaluation(List<String> formattedExpression) {
        Deque<Double> numbers = new LinkedList<>();
        for (String token : formattedExpression) {
            try {
                numbers.push(Double.parseDouble(token));
            } catch (NumberFormatException e) {
                performOperation(numbers, token);
            }
        }
        return numbers.pop();
    }
}
