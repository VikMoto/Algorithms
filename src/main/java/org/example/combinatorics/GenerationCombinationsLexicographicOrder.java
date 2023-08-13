package org.example.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerationCombinationsLexicographicOrder {
    public static void main(String[] args) {
        List<List<Integer>> lexicographicOrder =
                generationCombinationsLexicographicOrder(5, 3);
        System.out.println("lexicographicOrder = " + lexicographicOrder);
    }

    static List<List<Integer>> generationCombinationsLexicographicOrder(int number, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>() ;
        int[] supportSequence = generateSupportSequence(number, k);
        System.out.println("Arrays.toString(supportSequence) = " + Arrays.toString(supportSequence));

        while (true){
            combination = addCombination(supportSequence);
            result.add(combination);
            int end = -1;
            for ( int i = k - 1; i >= 0 ; i--) {
                if (supportSequence[i] <= (number - k + i) ) {
                    supportSequence[i]++;
                    end = i;
                    break;
                }
            }
            if (end == -1) {
                break;
            }
            for (int j = end + 1 ; j < k; j++) {
                supportSequence[j] = supportSequence[j - 1] + 1;
            }
        }
        return result;
    }

    private static List<Integer> addCombination(int[] supportSequence) {
        List<Integer> combination = new ArrayList<>();
        for (int s : supportSequence) {
            combination.add(s);
        }
        return combination;
    }

    private static int[] generateSupportSequence(int totalNumber, int elementsNumber) {
        int[] comb = new int[elementsNumber];
        for (int i = 0; i < comb.length; i++) {
            comb[i] = i + 1;
        }
        return comb;
    }
}
