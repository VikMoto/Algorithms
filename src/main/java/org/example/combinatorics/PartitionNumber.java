package org.example.combinatorics;

import java.util.Arrays;

/**
 Description of the algorithm
 1) Create a sequence of length n. We fill it with units. Let's move on to 2.
 2) If the length of the sequence is equal to 1, we end the algorithm. Otherwise,
    case, the sequence is the following partition. We use it and go to 3.
 3) Find the minimum element closest to the beginning of the sequence (search
    we pass from the beginning to the penultimate element). We increase it by one.
    Decrease the last element of the sequence by one. We calculate the sum
    elements to the right of the found minimum element. We create a new
    sequence of elements of the previous sequence starting from
    beginning and up to the found minimum and as many units as found
    before amount. Let's move on to 2.
 */
public class PartitionNumber {

    public static void main(String[] args) {
        int number = 20;
        int[] partition = new int[number];
        for (int i = 0; i < number; i++) {
            partition[i] = 1;
        }

        while (partition.length != 1){
            System.out.println(Arrays.toString(partition));
            partition = nextPartition(partition, number);
        }
    }
    public static int[] nextPartition(int[] partition, int number) {
        int i = 0;
        int n = partition.length;
        for (; i < n - 1  && partition[i] < partition[i + 1]; ) {
            i++;
        }
        partition[i] += 1;
        partition[n - 1] -= 1;
        int sum = 0;
        for (int j = i + 1; j < n; j++) {
            sum += partition[j];
        }
        int[] result = new int[i + 1 + sum];
        for (int j = 0; j <= i; j++) {
            result[j] = partition[j];
        }
        for (int j = i + 1; j < result.length; j++) {
            result[j] = 1;
        }
        return result;
    }
}
