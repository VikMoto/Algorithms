package org.example.sort;

import java.util.Arrays;

/**
  Sort O(n.log(n))
 Memory O(n)
 */
public class MergeIteratorSort {
    public static void main(String[] args) {
        int[] sequence = new int[]{5, 0, -2, 7, 3};
        mergeIteratorSort(sequence);
        System.out.println("sequence = " + Arrays.toString(sequence));
    }

    static void mergeIteratorSort(int[] sequence) {
        int[] support = Arrays.copyOf(sequence, sequence.length);
        int length = support.length;

        System.out.println("sequence = " + Arrays.toString(sequence));

        for (int size = 1; size < length; size *= 2) {
            for (int j = 0; j < length - size; j += 2 * size) {
                mergeSortingSequence(sequence, support,
                        j, j + size -1, j + size, Math.min(j + 2 * size - 1, length -1) );

            }
        }
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
