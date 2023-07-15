package org.example.sort;

import java.util.Arrays;

public class LomutoQuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 0, -2, 7, 3};
        System.out.println(Arrays.toString(array));
        lomutoQuickSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void lomutoQuickSort(int[] array) {
        lomutoQuickSort(array, 0, array.length - 1);
    }

    static void lomutoQuickSort(int[] array, int iStart, int iEnd) {
        if (iStart >= iEnd) return;
        int h = breakPartition(array, iStart, iEnd);
        lomutoQuickSort(array, iStart, h - 1);
        lomutoQuickSort(array, h + 1, iEnd);
    }

    private static int breakPartition(int[] array, int iStart, int iEnd) {
        int j = iStart;
        int pivotElement = array[0];
        for (int i = iStart + 1; i <= iEnd; i++) {
            if (array[i] < pivotElement) {
                j++;
                swap(array, i, j);
            }
        }
        swap(array,iStart, j);
        return j;
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
