package org.example.combinatorics;

import java.util.Arrays;

public class JohnsonTrotterAlgorithm {
    public static void main(String[] args) {
        permutationGenerator(3);
    }
    public static int findMaxMobileElement(int[] permutation, int[] direction) {
        int index = -1;
        for (int i = 0; i < permutation.length; i++) {
            int nextIndex = i + direction[i];
            if (nextIndex >= 0 && nextIndex < permutation.length) {
                if (permutation[i] > permutation[nextIndex]) {
                     if (index == -1) {
                         index = i;
                     } else if (permutation[i] > permutation[index]) {
                         index = i;
                     }
                }
            }
        }
        return index;
    }
    public static void changeDirection(int[] permutation, int[] direction,  int mobileElement) {
        for (int i = 0; i < permutation.length; i++) {
            if (permutation[i] > mobileElement) {
                direction[i] = direction[i] * (-1);
            }
        }
    }
    public static void permutationGenerator(int number) {
        int[] permutation = new int[number];
        int[] direction = new int[number];
        for (int i = 0; i < permutation.length; i++) {
            permutation[i] = i + 1;
            direction[i] = -1;
        }
        System.out.println("permutation = " + Arrays.toString(permutation));
        int indexMobileElement = findMaxMobileElement(permutation,direction);
        while (indexMobileElement != -1) {
            int mobileElement = permutation[indexMobileElement];
            int nextIndex = indexMobileElement + direction[indexMobileElement];
            swap(permutation, direction, indexMobileElement, nextIndex);
            changeDirection(permutation, direction, mobileElement);
            System.out.println("permutation = " + Arrays.toString(permutation));
            System.out.println("direction = " + Arrays.toString(direction));
            indexMobileElement = findMaxMobileElement(permutation,direction);
        }
    }
    static void swap(int[] permutation, int[] direction,  int indexMobileElement, int nextIndex) {
        int temp = permutation[indexMobileElement];
        permutation[indexMobileElement] = permutation[nextIndex];
        permutation[nextIndex] = temp;
        int temp2 = direction[indexMobileElement];
        direction[indexMobileElement] = direction[nextIndex];
        direction[nextIndex] = temp2;
    }
}
