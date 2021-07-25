package com.challenge.util;

import com.challenge.model.PolishExpressions;

import java.util.Arrays;
import java.util.List;

public class ValidatorUtil {

    private static final List<String> validOperators = Arrays.asList("+", "-", "*", "/");


    public static boolean checkIfExpressionIsValid(List<String> formattedExpression) {
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

    public static void validateIncomingParameters(PolishExpressions polishExpressions) {
        if(polishExpressions == null) {
            throw new IllegalArgumentException("'expressions' field must be present");
        }
    }
}
