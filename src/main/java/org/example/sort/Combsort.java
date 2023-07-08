package org.example.sort;

import java.util.Arrays;

/**
 worst time Sort O(n2)
 best time O(n log n)
 Memory O(n)
 * */
public class Combsort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 0, -2, 7, 3};
        combSort(array);

        System.out.println(Arrays.toString(array));

    }

    public static void combSort(int[] array) {
        int step = (int) (array.length / 1.247);
        int countSwaps = 1;

        while (true) {
            countSwaps = 0;
            for (int i = 0; i + step < array.length; i++) {
//                if ((i + step) > array.length) break; // DON`T WORK CONDITION!!!!
                if (array[i] > array[i + step]) {
                   swap(array, i, i + step);
                   countSwaps++;
                }
            }
            if (step == 1 && countSwaps == 0) {
                break;
            }
            step = (int)(step/1.247);
            if (step < 1) {step =1;}
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
