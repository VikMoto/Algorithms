package org.example.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LexicographicPermutationsNarayan {
    public static void main(String[] args) {
        List<List<Integer>> lists = permutationGeneratorNarayan(4);
    }
    static List<List<Integer>> permutationGeneratorNarayan(int number) {
        int[] permutation = new int[number];
        for (int i = 0; i < permutation.length; i++) {
            permutation[i] = i + 1;
        }
        List<Integer> permutations = new ArrayList<>();
        for (int i : permutation) {
            permutations.add(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(permutations);
        System.out.println(Arrays.toString(permutation));
        int index = findMaxIndex(permutation);

        while (index != -1){
             permutations = new ArrayList<>();
            int element = permutation[index];
            int j = findBiggerElement(permutation, element);
            swap(permutation, index, j);
            reverce(permutation, index + 1 , permutation.length - 1);
            for (int i : permutation) {
                permutations.add(i);
            }
            result.add(permutations);
            System.out.println(Arrays.toString(permutation));
            index = findMaxIndex(permutation);
        }
        return result;
    }
    static int findMaxIndex(int[] permutation) {
        for (int i = permutation.length - 2; i >= 0 ; i--) {
            if (permutation[i] < permutation[i + 1]) return i;
        }
        return -1;
    }
    static int findBiggerElement(int[] permutation, int element) {
        for (int i = permutation.length - 1; i >= 0 ; i--) {
            if (permutation[i] > element) return i;
        }
        return -1;
    }
    static void reverce(int[] permutation, int start, int end) {
        int offset = (end - start + 1) / 2 ;
        int shift = start ;
        for (int k = 0; k < offset; k++) {
            swap(permutation, k + shift, end - k );
        }
    }
    static void swap(int[] permutation, int i, int j) {
        int temp = permutation[i];
        permutation[i] = permutation[j];
        permutation[j] = temp;

    }
}
