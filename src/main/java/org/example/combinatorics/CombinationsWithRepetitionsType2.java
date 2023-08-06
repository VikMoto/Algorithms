package org.example.combinatorics;

import java.util.*;


public class CombinationsWithRepetitionsType2  {
    public static void main(String[] args) {
        List<List<Integer>> combinations = fillCombinations(4, 3);
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
    public static int[] nextCombination(int[] combination, int n) {
        int i = combination.length - 1;
        for (; i > -1 && combination[i] >= n - 1 ;) {
            i -= 1;
        }
        if (i == - 1) {
            return null;
        }
        combination[i] += 1;
        for (int j = i + 1; j < combination.length; j++) {
            combination[j] = combination[i];
        }
        return combination;
    }

    public static List<List<Integer>> fillCombinations(int numberOfElements, int kCombinations) {
        int[] combination = new int[kCombinations];
        List<Integer> combinations = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        combinations = addCombinationRevolver(combination);
        result.add(combinations);
        while (true) {
            combination = nextCombination(combination, numberOfElements);
//            System.out.println(Arrays.toString(combination));
            if (combination == null) {break;}
            combinations = addCombinationRevolver(combination);
            result.add(combinations);
        }
        return result;
     }

    private static List<Integer> addCombinationRevolver(int[] supportSequence) {
        List<Integer> combination = new ArrayList<>();
        for (int j = 0; j < supportSequence.length; j++) {
            combination.add(supportSequence[j]);
        }
        return combination;
    }
}

