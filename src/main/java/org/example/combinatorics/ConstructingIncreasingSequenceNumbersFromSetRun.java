package org.example.combinatorics;

import java.util.Arrays;

public class ConstructingIncreasingSequenceNumbersFromSetRun {
    public static void main(String[] args) {
        for (int[] parts : new ConstructingIncreasingSequenceNumbersFromSet(3)) {
            System.out.println(Arrays.toString(parts));
        }
    }
}
