package org.example.sort;

import java.util.Arrays;

/**
 worst time Sort O(n)
 Constrain - only Integer Numbers in not big range (up to 1000)

 Memory 2*range
 * */
public class CountingSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 0, -2, 7, 3, -2};

        countingSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static int[] countingSort(int[] array) {
        int[] minMax = findMinMax(array);
        int min = minMax[0];
        int max = minMax[1];
        int[] arrayHelp = new int[(max - min) + 1];
        int indexHelpArr = 0;

        //create help Array
        for (int i = 0; i < array.length; i++) {
            indexHelpArr = array[i] - min;
            arrayHelp[indexHelpArr] += 1;
        }

        int indexOuter = 0;
        //create sorting Array
        for (int i = 0; i < arrayHelp.length; i++) {
            if (arrayHelp[i] != 0) {
                int putingElement = i + min;
                for (int j = 0; j < arrayHelp[i]; j++) {
                   array[indexOuter] = putingElement;
                   indexOuter++;
                } 
            }
        }
        return array;
    }

    private static int[] findMinMax(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int element : array) {
            if (min > element) {
                min = element;
            }
            if (max < element) {
                max = element;
            }
        }
        return new int[] { min, max };
    }
}
