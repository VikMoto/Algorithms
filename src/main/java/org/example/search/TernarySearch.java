package org.example.search;

import org.example.sort.ThreeWayQuickSort;

/**

 Average performance O(lon(n))
 memory O(n)
 * */

public class TernarySearch {
    public static void main(String[] args) {
        int[] sequince = new int[] { -2, 0, 3, 5, 7, 9, 11, 15, 18, 21 };
        int element = 21;
        ThreeWayQuickSort.threeWayQuickSort(sequince);

        System.out.println(ternarySearch(sequince, element));
    }

    public static int ternarySearch(int[] sequince, int element) {
        int left = 0;
        int right = sequince.length - 1;
        int middle1 ;
        int middle2 ;
        int middleElement1;
        int middleElement2;

        while (left <= right){
            int h = (right - left) / 3;
            middle1 = left + h;
            middle2 = right - h;

            if (element == sequince[middle1] ) return middle1;
            if (element == sequince[middle2] ) return middle2;

            if ( element > sequince[middle2]) {
                left = middle2 + 1;
            } else if ( element < sequince[middle1]) {
                 right = middle1 - 1;
            } else {
                left = middle1 + 1;
                right = middle2 - 1;
            }
        }
        return -1;
    }
}
