package org.example.sort;

import java.util.Arrays;

/**
 Sort O(n2)
 Memmory O(n)
 * */
public class CocktailSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 0, -2, 7, 3};
        int indexLeft = 0;
        int indexRight = array.length - 1;
        int indexControl = indexRight;
        while (true) {
            for (int i = indexLeft; i < indexRight; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    indexControl = i;
                }
            }
            indexRight = indexControl;
            for (int i = indexRight; i > indexLeft; i--) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                    indexControl = i;
                }
            }
            indexLeft = indexControl;
            if (indexLeft >= indexRight) break;
        }

        System.out.println(Arrays.toString(array));

    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
