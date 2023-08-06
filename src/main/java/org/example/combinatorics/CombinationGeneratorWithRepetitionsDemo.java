package org.example.combinatorics;

import java.util.Arrays;

public class CombinationGeneratorWithRepetitionsDemo {

    public static void main(String[] args) {
        String[] sequence = new String[] {"A", "B", "C", "D"};

        for (String[] comb : new CombinationGeneratorWithRepetitions<>(sequence, 3)) {
            System.out.println(Arrays.toString(comb));
        }
    }
}
