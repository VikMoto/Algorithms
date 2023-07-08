package org.example.sort;

import java.util.Arrays;

/**
 worst time Sort O(n2)
 Memory O(n)
 Rule for finding position for element with value X:
 an ≤ X ≤ an+h
 h - step
 * */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 0, -2, 7, 3};
        int step = array.length / 2;

        while (step > 0) {
            for (int i = step; i < array.length; i++) {
                int j = i;
                while (j >= step && array[j] < array[j - step]) {
                    int temp = array[j];
                    array[j] = array[j - step];
                    array[j - step] = temp;
                    j -= step;
                }
            }
            step = step / 2;
        }
        System.out.println(Arrays.toString(array));
    }


}
