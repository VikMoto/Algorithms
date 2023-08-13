package org.example.combinatorics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 Description of the algorithm
 1) Create a sequence of length k. We fill it with values equal to zero (
     In what follows, we assume that the indexing in the sequence starts from zero).
     We return the first k - elements. This is the first placement. Let's move on to 2.
 2) Starting from the end of the sequence, we are looking for an element whose value is less than n-1.
   a) Such an element is found. We increase its value by one. Set values for
     all elements to the right equal to 0. Return the first k elements.
     Let's move on to 2.
   b) No such element found. We finish the algorithm.
 */

public class PlacementsWithRepetitions {
    public static void main(String[] args) {

        int numberOfElements = 5;
        int kCombinations = 3;
        int count = 1;
        int[] placement = new int[kCombinations];
        for (;placement !=null;) {
            System.out.println(Arrays.toString(placement) + " --- " + count++);
            placement = nextCombination(placement,numberOfElements);
        }

    }



    private static int[] nextCombination(int[] combination, int n) {
        int i = combination.length - 1;
        for (; i > -1 && combination[i] >= n - 1 ;) {
            i -= 1;
        }
        if (i == - 1) {
            return null;
        } else {
            combination[i] += 1;
            int j = i + 1;
            for (; j < combination.length; j++) {
                combination[j] = 0;
            }
        }
        return combination;
    }


}
