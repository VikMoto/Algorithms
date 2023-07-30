package org.example.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicPermutation {
    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        int n = 3;
        cyclicPermutation(n);
        long duration = System.currentTimeMillis() - startTimeMillis;
        System.out.println("duration  = " + duration);
        System.out.println("*******************************");
         startTimeMillis = System.currentTimeMillis();
        List<List<Integer>> lists = cyclicPermutationClassic(n);
         duration = System.currentTimeMillis() - startTimeMillis;
        System.out.println("duration = " + duration);

    }
    public static void cyclicPermutation(int number) {
        int[] permutation = new int[number];
        for (int i = 0; i < permutation.length; i++) {
            permutation[i] = i ;
        }
        int k = permutation.length - 1;
        System.out.println(Arrays.toString(permutation));
        int[] leftShift = permutation;

        while (k > 0) {
            leftShift = leftShift(leftShift,k);
            if (leftShift[k] != k) {
                System.out.println(Arrays.toString(leftShift));
                k = leftShift.length - 1;
            } else {
                k--;
            }
        }
    }

    public static int[] leftShift(int[] sequence, int k) {
        int[] result = new int[sequence.length];
        int numberOfElementsToCopy = k;
        int numberOfElementsToCopySecond =sequence.length - k ;
        System.arraycopy(sequence,1,result,
                0, numberOfElementsToCopy);
        if (k < sequence.length - 1) {
            System.arraycopy(sequence, k, result,
                    k , numberOfElementsToCopySecond);
        }
        result[k] = sequence[0];
        return  result;
    }

    public static List<List<Integer>> cyclicPermutationClassic(int number) {
        int[] permutation = new int[number];
        for (int i = 0; i < permutation.length; i++) {
            permutation[i] = i ;
        }
        List<Integer> permutations = new ArrayList<>();
        for (int i : permutation) {
            permutations.add(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(permutations);

        int k = permutation.length - 1;
        System.out.println(Arrays.toString(permutation));

        while (k > 0) {
            permutations = new ArrayList<>();
            leftShiftClassic(permutation,k);
            if (permutation[k] != k) {
                for (int i : permutation) {
                    permutations.add(i);
                }
                result.add(permutations);
                System.out.println(Arrays.toString(permutation));
                k = permutation.length - 1;
            } else {
                k--;
            }
        }
        return result;
    }
    public static void leftShiftClassic(int[] array, int k) {

        int temp = array[0];
        for (int i = 0; i < k; i++) {
            array[i] = array[i + 1];
        }
        array[k] = temp;
    }
}
