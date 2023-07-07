package org.example.sort;

import java.util.Arrays;

/**
 Sort O(n2)
 Memmory O(n)
 Правило нахождения позиции для элемента со значением X:
 an ≤ X ≤ an+1
 * */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 0, -2, 7, 3};
        for (int i = 1; i < array.length; i++) {
            int pasteElement = array[i];
            while (i > 0 &&  array[i - 1] > pasteElement ) {
                array[i] = array[i -1];
                i--;
            }
            array[i] = pasteElement;
        }
        System.out.println(Arrays.toString(array));
    }


}
