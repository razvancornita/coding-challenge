package com.challenge.tasks;

import com.challenge.util.ScannerUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        int sum = ScannerUtil.readNumbers(numbers);
        int result = computeNumberOfPairs(numbers, sum);
        System.out.println(result);
    }

    private static int computeNumberOfPairs(List<Integer> numbers, int sum) {
        Map<Integer, Integer> numOccurrences = computeNumOccurrences(numbers);
        return countNumberOfPairs(numOccurrences, numbers, sum);
    }


    private static Map<Integer, Integer> computeNumOccurrences(List<Integer> numbers) {
        Map<Integer, Integer> numOccurences = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            numOccurences.put(numbers.get(i), i);
        }
        return numOccurences;
    }

    private static int countNumberOfPairs(Map<Integer, Integer> numOccurences, List<Integer> numbers, int sum) {
        int numPairs = 0;

        for (int i = 0; i < numbers.size(); i++) {
            Integer iValue = numbers.get(i);
            Integer jValue = sum - iValue;
            Integer jPosition = numOccurences.get(jValue);

            if (jPosition != null && jPosition > i) {
                numPairs++;
            }
        }
        return numPairs;
    }
}
