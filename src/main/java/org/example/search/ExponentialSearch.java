package org.example.search;

import org.example.sort.ThreeWayQuickSort;

import java.util.Arrays;

/**

 k - index searching element
 Average performance	O(log k
 */
public class ExponentialSearch {
    public static void main(String[] args) {
        int[] sequince = new int[] { -2, 11, 0, 3, 5, 7, 9, 64 , 15, 18, -7 };
        ThreeWayQuickSort.threeWayQuickSort(sequince);
        System.out.println(Arrays.toString(sequince));

        int element = 70;
        System.out.println("binarySearch(sequince, element) = " + exponentialSearch(sequince, element));

    }

    public static int exponentialSearch(int[] sequince, int element){
        int result;
        int border = 1;
        while (border < sequince.length && sequince[border] < element ) {
            border *= 2;
        }

        int left = border / 2;
        int right;
        if (border > sequince.length - 1) right = sequince.length - 1;
        else right = border;
        result = binarySearch(sequince, element, left, right);
        return result;
    }

    public static int binarySearch(int[] sequince, int element, int left, int right ) {
        int middle ;
        int middleElement;

        while (left <= right){
            middle = left + (right - left) / 2;
            middleElement = sequince[middle];
            if (element == middleElement ) return middle;
            if ( element > middleElement) {
                left = middle + 1;
                }
            if ( element < middleElement) {
                right = middle - 1;
                }
        }
        return -1;
    }
}
