package org.example.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
  Binary Gray Code
 Description of the algorithm

 1) Create an additional sequence of size n+1 (hereinafter a). fill it up
 zeros. Declare an additional variable j=0. Go to 2.
 2) Return the first n elements of the sequence in reverse order. Go to 3.
 3) Set a[n]=1-a[n] go to 4.
 4) If a[n]==1 set j=0. Otherwise, starting from the beginning of the sequence
 search for an element for which a[j]==1. Set j=j+1. Go to 5.
 5) If j==n terminate the algorithm. Set a[j]=1-a[j] go to 2.
 */

public class BinaryGrayCode {
    public static void main(String[] args) {
        List<List<Integer>> binaryGrayCode = binaryGrayCode(3);
        for (List<Integer> list : binaryGrayCode) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> binaryGrayCode(int n) {
        List<List<Integer>> result = new ArrayList<>();
        int[] supportSequence = new int[n + 1];
        int j = 0;
        while (j != n) {
            //step 2
            List<Integer> combination = new ArrayList<>();
            for (int i = supportSequence.length - 2; i >= 0 ; i--) {
                combination.add(supportSequence[i]);
            }
            result.add(combination);
            //step 3
            supportSequence[n] = 1 - supportSequence[n];
            //step 4
            if (supportSequence[n] == 1) {
                j = 0;
            } else {
                for ( j = 0; j < supportSequence.length ; j++) {
                    if (supportSequence[j] == 1) {
                        j += 1;
                        break;
                    }
                }
            }
            if (j == n) {
                return result;
            } else {
                supportSequence[j] = 1 - supportSequence[j];
            }
        }
        return result;
    }
}
