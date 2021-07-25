package com.challenge.util;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@UtilityClass
public class ScannerUtil {

    public static int readNumbers(List<Integer> numbers) {
        try (Scanner scanner = new Scanner(System.in)) {
            int k = scanner.nextInt();

            //because we do not read number of numbers from keyboard, we do not know when to stop reading lines from keyboard
            //we will also read n from keyboard
            int n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                numbers.add(scanner.nextInt());
            }
            return k;
        }
    }

    public static List<String> readExpressions() {
        try (Scanner scanner = new Scanner(System.in)) {
            int numLines = scanner.nextInt();
            scanner.nextLine();
            List<String> expressions = new ArrayList<>();
            for (int i = 0; i < numLines; i++) {
                expressions.add(scanner.nextLine());
            }
            return expressions;
        }
    }
}
