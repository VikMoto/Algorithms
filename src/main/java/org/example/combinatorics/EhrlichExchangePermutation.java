package org.example.combinatorics;

import java.util.ArrayList;
import java.util.List;

public class EhrlichExchangePermutation {
    public static void main(String[] args) {
        Character[] array = new Character[] { 'a', 'b', 'c', 'd'};
        String[] original = new String[]{"Do", "You", "Want", "Eat"};
        List<List<Character>> exchangePermutation = ehrlichExchangePermutation(array);
        List<List<String>> exchangePermutation2 = ehrlichExchangePermutation(original);
    }
    public static <T> List<List<T>> ehrlichExchangePermutation(T[] permutation) {
        List<List<T>> result = new ArrayList<>();
        List<T> permutations = new ArrayList<>();
        int[] baseSuppurt = new int[permutation.length];
        int[] cSuppurt = new int[permutation.length + 1];
        for (int i = 0; i < baseSuppurt.length; i++) {
            baseSuppurt[i] = i;
        }
        for (int c : cSuppurt) {
            c = 0;
        }
        int k = 1;
        int j = 1;
        for (T c : permutation) {
            permutations.add(c);
        }
        result.add(permutations);

        while (true) {
            permutations = new ArrayList<>();
            k = 1;
            for (; cSuppurt[k] == k; ) {
                cSuppurt[k++] = 0;
            }
            if (k == permutation.length) {
                break;
            }
            cSuppurt[k] = cSuppurt[k] + 1;
            swap(permutation, 0, baseSuppurt[k]);
            for (T character : permutation) {
                permutations.add(character);
            }
            result.add(permutations);
            j = 1;
            k = k - 1;
            while (j < k) {
                swapInt(baseSuppurt, j++, k--);
            }
        }
        return result;
    }
    static <T> void swap(T[] permutation, int j, int k) {
        T temp = permutation[j];
        permutation[j] = permutation[k];
        permutation[k] = temp;
    }
    static void swapInt(int[] ints, int j, int k) {
        int temp = ints[j];
        ints[j] = ints[k];
        ints[k] = temp;
    }
}
