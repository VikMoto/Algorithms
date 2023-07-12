package org.example.sort;

import java.util.Arrays;

/**
 Sort O(n)
 Memory plus O(n)
 * */
public class RadixSort {
    public static void main(String[] args) {
        int[] numbers = new int[]{121, 5, 24, 9, 32};
        int[] result = radixSort(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(result));
    }

    public static int[] radixSort(int[] numbers) {
        int maxNumbersOfDigits = findMaxNumberOfDigits(numbers);
        int devider = 1;
        for (int i = 0; i < numbers.length; i++) {
            numbers = distributingCountingSort(numbers,devider);
            devider *=10;
        }
        return numbers;
    }

    private static int numberOfDigit(int number) {
        int i = 1;
        long n = 10;
        while (number >= n) {
            i++;
            n *= 10;
        }
        return i;
    }

    private static int findMaxNumberOfDigits(int[] numbers) {
        int result = 1;
        for (int i = 0; i < numbers.length; i++) {
            int digits = numberOfDigit(numbers[i]);
            if (digits > result) result = digits;
        }
        return result;
    }

    private static int getDigit(int number, int devider) {
        return number % (devider * 10) / devider;

    }

    private static int[] findMinMaxKey(int[] numbers, int devider) {
        if (numbers.length == 0) {
            return new int[]{0, 0};
        }
        int minKey = getDigit(numbers[0], devider);
        int maxKey = minKey;
        for (int number : numbers) {
            int digit = getDigit(number, devider);
            if (minKey > digit) {
                minKey = digit;
            }
            if (maxKey < digit) {
                maxKey = digit;
            }
        }
        return new int[]{minKey, maxKey};
    }

    private static int[] distributingCountingSort(int[] numbers, int devider) {
        int[] minMax = findMinMaxKey(numbers, devider);
        int minKey = minMax[0];
        int maxKey = minMax[1];
        int[] support = new int[(maxKey - minKey) + 1];
        int indexSupport = 0;

        //create support Array
        for (int i = 0; i < numbers.length; i++) {
            indexSupport = getDigit(numbers[i],devider) - minKey;
            support[indexSupport] += 1;
        }

        int size = numbers.length;
        //distribution counting
        for (int i = support.length - 1; i >=0 ; i--) {
            int currentElement = support[i];
            support[i] = size - currentElement;
            size = size - currentElement;
        }

        int index = 0;
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            index = support[getDigit(numbers[i],devider) - minKey ];
            result[index] = numbers[i];
            support[getDigit(numbers[i],devider) - minKey] += 1;
        }
        return result;
    }
}
