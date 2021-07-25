package com.challenge.tasks;

import com.challenge.service.ExpressionService;
import com.challenge.util.ScannerUtil;

import java.util.List;

public class Problem2 {
    private static final ExpressionService expressionService = new ExpressionService();

    public static void main(String[] args) {
        List<String> expressions = ScannerUtil.readExpressions();
        for (String expression : expressions) {
            System.out.println(expressionService.processExpression(expression));
        }
    }
}
