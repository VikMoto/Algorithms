package org.example.sort;

import java.util.Arrays;

/**
 In 3 Way QuickSort, an array arr[l..r] is divided in 3 parts:
 a) arr[l..lt] elements less than pivot.
 b) arr[lt+1..gt-1] elements equal to pivot.
 c) arr[gt..hi] elements greater than pivot.
 */
public class ThreeWayQuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 2, 4, 2, 4, 1, 2, 3, 1, 2, 2, 2, 2, 3, 1, 4, 4, 4};
        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
        threeWayQuickSort(array);
        System.out.println();
        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));

    }

    public static void threeWayQuickSort(int[] array) {
        threeWayQuickSort(array, 0, array.length - 1);
    }

    public static void threeWayQuickSort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int[] part = breakPartition(array, lo, hi);
        threeWayQuickSort(array, lo, part[0] - 1);
        threeWayQuickSort(array, part[1] + 1, hi);
    }

    //Deykstra partition
    private static int[] breakPartition(int[] array, int lo, int hi) {
        int pivot = array[lo];
        System.out.print(pivot + ". ");
        int i = lo + 1;
        int lt = lo;
        int gt = hi;

        while (i <= gt) {
            if (array[i] < pivot) {
                swap(array, lt, i);
                lt++;
                i++;
            } else if (array[i] > pivot) {
                swap(array, gt, i);
                gt--;
            } else {
                i++;
            }
        }
        return new int[]{ lt, gt };
    }
    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
