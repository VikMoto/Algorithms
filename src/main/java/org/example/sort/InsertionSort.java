package org.example.sort;

import java.util.Arrays;

/**
 Sort O(n2)
 Memory O(n)
 Rule for finding position for element with value X:
 an ≤ X ≤ an+1
 * */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 0, -2, 7, 3};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int pasteElement = array[i];
            while (i > 0 &&  array[i - 1] > pasteElement ) {
                array[i] = array[i -1];
                i--;
            }
            array[i] = pasteElement;
        }
    }


}
