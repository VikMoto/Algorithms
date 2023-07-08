package org.example.sort;

import java.util.Arrays;

/**
 worst time Sort O(n)
 Constrain - only Integer Numbers in not big range (up to 1000)

 Memory 2*range
 * */
public class CountingSort2 {
    public static void main(String[] args) {
        int[] array = new int[]{5, 0, -2, 7, 3, -2};

        int[] minMax = findMinMax(array);
        int minValue = minMax[0];
        int maxValue = minMax[1];
        int[] arrayHelp = new int[(maxValue - minValue) + 1];
        int indexHelpArr = 0;

        for (int i = 0; i < array.length; i++) {
            indexHelpArr = array[i] - minValue;
            arrayHelp[indexHelpArr] += 1;
        }

        int index = 0;
        for (int i = 0; i < arrayHelp.length; i++) {
            if (arrayHelp[i] != 0) {
                for (int j = 0; j < arrayHelp[i]; j++) {
                    array[index] = i + minValue;
                    index++;
                }
            }
        }

        System.out.println(Arrays.toString(array));
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
