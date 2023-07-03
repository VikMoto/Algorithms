package org.example.sort;

import java.util.Arrays;

/**
 Sort O(n2)
 Memmory O(n)
 * */
public class GnomeSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 0, -2, 7, 3};
        int index = 1;
        int i = 0;
        int n = array.length;

        while (i < n - 1) {
            if (array[i] <= array[i +1]) {
                i = index;
                index++;
            } else {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                i--;
                if (i < 0) {
                    i = index;
                    index++;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
