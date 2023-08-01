package org.example.combinatorics;

import java.util.*;

public class CombinationsGenerator {
    public static void main(String[] args) {
        List<List<Integer>> combinationsed = combinationsGenerator(5, 3);
        System.out.println("combinationsed = " + combinationsed);
    }
    
    public static List<List<Integer>> combinationsGenerator(int totalNumber, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>() ;
        int[] supportSequence = generateSupportSequence(totalNumber, k);
        System.out.println("Arrays.toString(supportSequence) = " + Arrays.toString(supportSequence));
        combination = new ArrayList<>();
        for (int j = 0; j < supportSequence.length - 2; j++) {
            combination.add(supportSequence[j]);
        }

        while (true) {
            combination = new ArrayList<>();
            for (int j = 0; j < supportSequence.length - 2; j++) {
                combination.add(supportSequence[j]);
            }
            result.add(combination);
//            System.out.println("combination = " + combination);
            int j = 0;
            while (supportSequence[j] + 1 == supportSequence[j + 1]) {
                supportSequence[j] = j;
                j++;
            }
                if( j < k){
                  supportSequence[j] += 1;
                }else {
                    break;
                }
            }
        return result;
    }

    private static int[] generateSupportSequence(int totalNumber, int elementsNumber) {
        int[] comb = new int[elementsNumber + 2];
        for (int i = 0; i < comb.length - 2; i++) {
            comb[i] = i;
        }
        comb[comb.length - 2] = totalNumber;
        comb[comb.length - 1] = 0;
        return comb;
    }

}
