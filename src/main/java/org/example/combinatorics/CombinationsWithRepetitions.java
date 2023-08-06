package org.example.combinatorics;

import java.util.ArrayList;
import java.util.List;

public class CombinationsWithRepetitions {
    public static void main(String[] args) {
        List<List<Integer>> combinationsed =
                combinationsWithRepetitions(4, 3);
        System.out.println("combinationsed = " + combinationsed);
    }
    public static List<List<Integer>> combinationsWithRepetitions(
            int numberOfElements, int kCombinations) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        int[] supportSequence = generateSequence(kCombinations);
        combination = addCombinationRevolver(supportSequence);
        result.add(combination);

        int end = 0;
        while (end != -1) {

            for (int i = kCombinations - 1; i >= 0; i--) {
                if (supportSequence[i] < numberOfElements - 1) {
                    supportSequence[i] += 1;
                    for (int j = i + 1; j < supportSequence.length; j++) {
                            supportSequence[j] = supportSequence[i];
                        }
                    combination = addCombinationRevolver(supportSequence);
                    result.add(combination);
                    break;
                }else if (i == 0){
                    end = -1;
                    break;
                }
            }
        }
        return result;
    }

    private static int[] generateSequence( int number) {
        int[] result = new int[number];
        for (int i = 0; i < number; i++) {
            result[i] = 0;
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
