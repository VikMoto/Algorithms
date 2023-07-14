package org.example.sort;

import java.util.Arrays;
/**
 Sort O(n.log(n))
 Memory O(n)
 */
public class MergeRecursiveSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 0, -2, 7, 3};

        System.out.println(Arrays.toString(array));
        mergeRecursiveSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeRecursiveSort(int[] array) {
        int[] support = Arrays.copyOf(array, array.length);
        int startIndex = 0;
        int endIndex = support.length - 1;
        mergeRecursiveSort(array,support, startIndex, endIndex);
    }

    private static void mergeRecursiveSort(int[] array, int[] support,
                                           int startIndex, int endIndex) {
        if (startIndex >= endIndex) return;
        //find middle of sequence
        int h = startIndex + (endIndex - startIndex) / 2;
        mergeRecursiveSort(array,support,startIndex, h);
        mergeRecursiveSort(array,support,h + 1, endIndex);
        mergeSortingSequence(array,support,startIndex,h,h + 1,endIndex );
    }

    static void mergeSortingSequence(int[] sequence, int[] support,
                                     int lStart, int lEnd, int rStart, int rEnd) {
        for (int i = lStart; i <= rEnd; i++) {
            support[i] = sequence[i];
        }
        int l = lStart;
        int r = rStart;
        for (int i = lStart; i <= rEnd; i++) {
            if (l > lEnd) {
                sequence[i] = support[r];
                r++;
            } else if (r > rEnd) {
                sequence[i] = support[l];
                l++;
            } else if (support[l] < support[r]) {
                sequence[i] = support[l];
                l++;
            }else {
                sequence[i] = support[r];
                r++;
            }
        }
    }
}
