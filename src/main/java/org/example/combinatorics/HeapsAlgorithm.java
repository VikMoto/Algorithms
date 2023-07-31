package org.example.combinatorics;

import java.util.ArrayList;
import java.util.List;

public class HeapsAlgorithm {
    public static void main(String[] args) {
        Character[] array = new Character[] { 'a', 'b', 'c'};
        List<List<Character>> result = new ArrayList<>();
        int k = array.length;
        heapsAlgorithmPermutation(array, k , result);
        for (List<Character> characters : result) {
            System.out.println(characters);
        }
    }

    public static <T> void   heapsAlgorithmPermutation(T[]  permutation, int k, List<List<T>> result) {
        List<T> permutations = new ArrayList<>();
        for (T t : permutation) {
            permutations.add(t);
        }
        if (k == 1) {
            result.add(permutations);
            return;
        }

        for (int i = 0; i < k; i++) {
            heapsAlgorithmPermutation(permutation,k - 1, result);
            if (k % 2 == 0) {
                swap(permutation, i, k - 1 );
            } else  {
                swap(permutation, 0, k - 1);
            }
        }
    }

    static <T> void swap(T[] permutation, int i, int k) {
        T temp = permutation[i];
        permutation[i] = permutation[k];
        permutation[k] = temp;
    }
}
