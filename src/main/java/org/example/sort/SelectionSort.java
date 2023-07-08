package org.example.sort;

import java.util.Arrays;

/**
 Sort O(n2)
 Memory O(n)
 * */

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 0, -2, 7, 3};

        int minIndex = 0;

        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }

        System.out.println("array = " + Arrays.toString(array));

    }
}
