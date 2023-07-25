package org.example.search;

import org.example.sort.ThreeWayQuickSort;

import java.util.Arrays;

public class InterpolationSearch {
    public static void main(String[] args) {
        int[] sequince = new int[] { -2, 0, 3, 5, 7, 9, 11, 15, 18, 21 };
        ThreeWayQuickSort.threeWayQuickSort(sequince);
        System.out.println(Arrays.toString(sequince));

        int element = 6;
        System.out.println("interpolationSearch(sequince, element) = "
                + interpolationSearch(sequince, element));

    }

    public static int interpolationSearch(int[] sequence, int element) {
        int l = 0;
        int r = sequence.length -1;
        int result = -1;
        int index = 0;

        while ((r - l) > 0) {
             index = linearInterpolation(sequence, element, l, r);
            if (sequence[index] == element) {
                result = index;
                return result;
            }
            if (sequence[index] > element) {
                r = index - 1;
            } else if (sequence[index] < element) {
                l = index + 1;
            }
        }
        return result;
    }
    private static int linearInterpolation(int[] sequince, int element, int l, int r){
        return ( (element - sequince[l]) * (l - r) ) / (sequince[l] - sequince[r]) + l;
    }
}
