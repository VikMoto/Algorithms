package org.example.sort;

import java.util.Arrays;

/**
 In 3 Way QuickSort, an array arr[l..r] is divided in 3 parts:
 a) arr[l..lt] elements less than pivot.
 b) arr[lt+1..gt-1] elements equal to pivot.
 c) arr[gt..hi] elements greater than pivot.
 */
public class ThreeWayBentleyMcLroyQuickSort {
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
        int[] part = breakPartitionBentleyMcLroy(array, lo, hi);
        threeWayQuickSort(array, lo, part[0] );
        threeWayQuickSort(array, part[1], hi);
    }

    //Deykstra partition
    private static int[] breakPartitionBentleyMcLroy(int[] array, int lo, int hi) {
        int pivot = array[lo];
        System.out.print(pivot + ". ");
        int i = lo + 1;
        int p = lo;
        int j = hi;
        int g = hi + 1;

        while (true) {
            for (; i < hi && array[i] < pivot; i++) {
            }
            for (; array[j] > pivot; j--) {
            }
            if (i >= j) {
                if (i == j && array[i] == pivot) {
                    swap(array, i, p++);
                }
                break;
            }
            swap(array, i, j);
                if (array[i] == pivot) {
                    swap(array, i, ++p);
                }
                if (array[j] == pivot) {
                    swap(array, j, --g);
                }
                i++;
                j--;
            }
        for (int k = lo; k < p; k++) {
            swap(array,k, j--);
        }
        for (int k = hi; k > g; k--) {
            swap(array,k , i++);
        }
        return new int[]{ j, i };
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
