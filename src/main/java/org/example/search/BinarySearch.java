package org.example.search;

import org.example.sort.ThreeWayQuickSort;

import java.util.Arrays;

/**
 Worst-case performance	O(log n)
 Best-case performance	O(1)
 Average performance	O(log n)
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] sequince = new int[] { -2, 11, 0, 3, 5, 7, 9, 64 , 15, 18, -7 };
        ThreeWayQuickSort.threeWayQuickSort(sequince);
        System.out.println(Arrays.toString(sequince));

        int element = -2;
        System.out.println("binarySearch(sequince, element) = " + binarySearch(sequince, element));

    }

    public static int binarySearch(int[] sequince, int element) {
        int left = 0;
        int right = sequince.length - 1;
        int middle ;
        int middleElement;

        while (true){
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
    }
}
