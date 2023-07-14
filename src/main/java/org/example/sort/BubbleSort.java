package org.example.sort;

import java.util.Arrays;

/**
 Sort O(n2)
 Memmory O(n)
 * */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 0, -2, 7, 3};
        int maxIndex = array.length;
        while (true) {
            int numberOfSwap = 0;
            for (int i = 0; i < maxIndex - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    numberOfSwap++;
                }
            }
            maxIndex--;
            if (numberOfSwap == 0) break;
        }

        System.out.println("array = " + Arrays.toString(array));
    }

}
