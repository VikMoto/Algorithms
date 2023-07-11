package org.example.sort;

import java.util.Arrays;

/**
 Sort O(n + n2/k)
 Memory plus O(n)
 k - amount of buckets
 * */
public class BucketSort {
    public static void main(String[] args) {
        int[] array = new int[]{12, 2, 4, 7, 5, 10, 8, 9, 11, 9};
        int buckets = 5;

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(bucketSort(array, buckets)));


    }

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int pasteElement = array[i];
            while (i > 0 &&  array[i - 1] > pasteElement ) {
                array[i] = array[i -1];
                i--;
            }
            array[i] = pasteElement;
        }
        return array;
    }

    public static int[] bucketSort(int[] array, int numberOfBuckets) {
        int[] minMax = findMinMax(array);
        int[] result = new int[array.length];
        int min = minMax[0];
        int max = minMax[1];
        if (min == max) {
            return array;
        }
        int[][] buckets = new int[numberOfBuckets][];
        int[] addIndex = new int[numberOfBuckets];
        int[] bucketSize = calculateBucketSize(array, numberOfBuckets);

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new int[bucketSize[i]];
        }

        for (int i = 0; i < array.length; i++) {
            int bucketNumber = (numberOfBuckets * (array[i] - min) )/ (max - min + 1);
            buckets[bucketNumber][addIndex[bucketNumber]++] = array[i];
        }

        for (int[] bucket : buckets) {
            if (bucket.length <= 32) {
                insertionSort(bucket);
            } else {
                bucketSort(bucket, numberOfBuckets);
            }
        }

        int insertIndex = 0;
        for (int[] bucket : buckets) {
            for (int i = 0; i < bucket.length; i++) {
                result[insertIndex] = bucket[i];
                insertIndex++;
            }
        }

        return result;
    }

    private static int[] calculateBucketSize(int[] array, int numberOfBuckets) {
        int[] bucketSize = new int[numberOfBuckets];
        int[] minMax = findMinMax(array);
        int min = minMax[0];
        int max = minMax[1];
        for (int i = 0; i < array.length; i++) {
            int blockNumber = (numberOfBuckets * (array[i] - min) )/ (max - min + 1);
            bucketSize[blockNumber] += 1;
        }
         return bucketSize;
    }
    private static int[] findMinMax(int[] array) {
        if (array.length == 0) {
            return new int[]{0,0};
        }
        int min = array[0];
        int max = array[0];
        for (int element : array) {
            if (min > element) {
                min = element;
            }
            if (max < element) {
                max = element;
            }
        }
        return new int[] { min, max };
    }
}
