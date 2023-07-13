package org.example.sort;

import java.util.Arrays;

public class MergeSortingSequences {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 6, 9};
        int[] array2 = new int[]{2, 4, 4, 7};


        int[] result = mergeSortingSequence(array, array2);
        System.out.println("result = " + Arrays.toString(result));
    }

    static int[] mergeSortingSequence(int[] array, int[] array2) {
        int l = 0;
        int r = 0;
        int[] result = new int[array.length + array2.length];
        for (int i = 0; i < result.length; i++) {
            if (l >= array.length) {
               result[i] = array2[r];
               r++;
            } else if (r >= array2.length) {
                result[i] = array[l];
                l++;
            } else if (array[l] < array2[r]) {
                result[i] = array[l];
                l++;
            }else {
                result[i] = array2[r];
                r++;
            }
        }
        return result;
    }
}
