package org.example.sort;


import java.util.Arrays;

public class HoareQuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 0, -2, 7, 3};
        System.out.println(Arrays.toString(array));
        hoareQuickSort(array);
        System.out.println(Arrays.toString(array));
    }

    static void hoareQuickSort(int[] array) {
        hoareQuickSort(array, 0, array.length - 1);

    }
    static void hoareQuickSort(int[] array, int iStart, int iEnd) {
        if (iStart >= iEnd) return;
        int h = breakPartition(array, iStart, iEnd);
        //sort left part
        hoareQuickSort(array,iStart, h - 1);
        //sort right part
        hoareQuickSort(array,h + 1, iEnd);
    }

    static int breakPartition(int[] array, int iStart, int iEnd) {
        int i = iStart + 1;
        int pivotElement = array[0];
        int j = iEnd;
        while (true) {
            for (; i < iEnd && array[i] < pivotElement; ) {
                i += 1;
            }

            for (; array[j] > pivotElement; ) {
                j -= 1;
            }

            if (i >= j) break;
            //AFTER Swap Have Must i += 1 and j -= 1!!!!
            swap(array, i++, j--);
        }
        swap(array, iStart, j);
        return j;
    }
    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
