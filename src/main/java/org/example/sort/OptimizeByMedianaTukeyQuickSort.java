package org.example.sort;

import java.util.Arrays;
/**
 * [3, 1, 4, 4, 5, 9, 9, 8, 2]
 yA = median( 3, 1, 4 ) = 3
 yB = median( 4, 5, 9 ) = 5
 yC = median( 9, 8, 2 ) = 8
 median = (3,5,8) = 5
 */

public class OptimizeByMedianaTukeyQuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{3, 1, 4, 4, 5, 9, 9, 8, 2};
//                                3, 1, 4, 4, 5, 9, 9, 8, 2,
//                                3, 1, 4, 4, 5, 9, 9, 8, 2,
//                                3, 1, 4, 4, 5, 9, 9, 8, 2,
//                                3, 1, 4, 4, 5, 9, 9, 8, 2,
//                                3, 1, 4, 4, 5, 9, 9, 8, 2};
        System.out.println(Arrays.toString(array));
        hoareQuickSort(array);
        System.out.println(Arrays.toString(array));
    }


    static int medaina(int[] array, int iStart, int iMid, int iEnd ){
        if (array[iStart] <= array[iMid]) {
            if (array[iMid] <= array[iEnd]) return iMid;
        }else {
            if (array[iStart] <= array[iEnd]) return iStart;
        }
        return iEnd;
    }

    static int tukeyMediana(int[] array, int iStart, int iEnd) {
        int part = (iEnd - iStart) / 3;
        int medianA = medaina(array, iStart, iStart + part /2, iStart + part);
        int medianB = medaina(array, iStart + part + 1, iStart + 3 * part /2 + 1, iStart + 2 * part);
        int medianC = medaina(array, iStart + 2 * part + 1, iStart + 5 * part /2 + 1, iEnd);

        return medaina(array, medianA, medianB, medianC);
    }
    static void hoareQuickSort(int[] array) {
        hoareQuickSort(array, 0, array.length - 1);

    }
    static void hoareQuickSort(int[] array, int iStart, int iEnd) {
        if (iEnd - iStart <= 32) {
            insertionSort(array, iStart, iEnd);
            return;
        }
        int medianaIndex = tukeyMediana(array,iStart, iEnd);
        swap(array, iStart, medianaIndex);

        int h = breakPartition(array, iStart, iEnd);
        //sort left part
        hoareQuickSort(array,iStart, h - 1);
        //sort right part
        hoareQuickSort(array,h + 1, iEnd);
    }

    static int breakPartition(int[] array, int iStart, int iEnd) {
        int i = iStart + 1;
        int pivotElement = array[iStart];
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

    private static void insertionSort(int[] array, int iStart, int iEnd) {
        for (int i = iStart; i <= iEnd; i++) {
            int pasteElement = array[i];
            while (i > 0 &&  array[i - 1] > pasteElement ) {
                array[i] = array[i -1];
                i--;
            }
            array[i] = pasteElement;
        }
    }
    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
