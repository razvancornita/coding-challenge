package com.challenge.tasks;

import com.challenge.service.PairService;
import com.challenge.util.ScannerUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    private static final PairService pairService = new PairService();

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        int sum = ScannerUtil.readNumbers(numbers);
        int result = pairService.computeNumberOfPairs(numbers, sum);
        System.out.println(result);
    }
}
