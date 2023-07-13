package org.example.sort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RadixSortTest {

    @Test
    public void testRadixSort() {
        int[] numbers = {121, 5, 24, 9, 32};
        int[] expected = {5, 9, 24, 32, 121};
        int[] result = RadixSort.radixSort(numbers);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testNumberOfDigit() {
        int number = 121;
        int expected = 3;
        int result = RadixSort.numberOfDigit(number);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindMaxNumberOfDigits() {
        int[] numbers = {121, 5, 24, 9, 32};
        int expected = 3;
        int result = RadixSort.findMaxNumberOfDigits(numbers);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetDigit() {
        int number = 121;
        int devider = 10;
        int expected = 2;
        int result = RadixSort.getDigit(number, devider);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindMinMaxKey() {
        int[] numbers = {121, 5, 24, 9, 32};
        int devider = 10;
        int[] expected = {0, 3};
        int[] result = RadixSort.findMinMaxKey(numbers, devider);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testDistributingCountingSort() {
        int[] numbers = {9, 5};
        int devider = 1;
        int[] expected = {5, 9};
        int[] result = RadixSort.distributingCountingSort(numbers, devider);
        Assertions.assertArrayEquals(expected, result);
    }
}
