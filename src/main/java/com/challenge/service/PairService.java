package com.challenge.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairService {
    public int computeNumberOfPairs(List<Integer> numbers, int sum) {
        Map<Integer, Integer> numOccurrences = computeNumOccurrences(numbers);
        return countNumberOfPairs(numOccurrences, numbers, sum);
    }


    private Map<Integer, Integer> computeNumOccurrences(List<Integer> numbers) {
        Map<Integer, Integer> numOccurences = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            numOccurences.put(numbers.get(i), i);
        }
        return numOccurences;
    }

    private int countNumberOfPairs(Map<Integer, Integer> numOccurences, List<Integer> numbers, int sum) {
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
