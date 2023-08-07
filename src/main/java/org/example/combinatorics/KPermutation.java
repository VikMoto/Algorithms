package org.example.combinatorics;

import java.util.Arrays;

/**
 Description of the algorithm
 1) Create a sequence of length n. We fill it with values equal to the index of the element
    (In what follows, we assume that the indexing in the sequence starts from zero).
    We choose k. We return the first k - elements. This is the first placement. Let's move on to 2.
 2) Get the value at index k-1 in the sequence. We search from
    k-th index and to the end. We are looking for the index of the minimum element that is greater than the element
    standing at k-1 index. Let's move on to 3.
 3) Two cases are possible:
   a) If such an index was found (hereinafter j) then we exchange values for k-1 and j
      indexes. As the next placement, we return the first k elements. Let's move on to 2.
   b) Index not found. Let's move on to 4.
 4) Reverse from the k-th index to the end of the sequence. We search starting from
    k-1 index and up to 0 (reverse pass). We are looking for such an element that s[i]<s[i+1]. Two cases are possible.
    a) Such an element is found. Then we perform a search starting from the end of the sequence and up to i.
    We are looking for the index of the minimum element that will be greater than s[i]. We swap them and
    we reverse the sequence from index i+1. We return the first k elements.
    Go to 2.
 b) No such element found. We finish the algorithm.
 */

public class KPermutation {
    public static void main(String[] args) {
        int[] number = new int[] { 0, 1, 2, 3, 4 };
        int k = 3;

        int[] perm = Arrays.copyOfRange(number, 0, k);
        for (; perm != null;) {
            System.out.println(Arrays.toString(perm));
            perm = getNextKPermutation(k, number);
        }
    }

    private static int[] getNextKPermutation(int k, int[] number) {
        int n = number.length;
        int i = k;
        for (; i < n && number[i] < number[k - 1]; ) {
            i +=1;
        }
            if (i < n) {
                swap(number, i, k - 1);
            } else{
                reverse(number, k - 1 , n -1);
                int j = k - 2;
                for (; j >= 0 && number[j] > number[j + 1] ;) {
                    j -= 1;
                }
                if (j < 0) {
                    return null;
                }else {
                    i = n - 1;
                    for (; i > j ;) {
                        if (number[i] > number[j]) {
                            break;
                        }
                        i -= 1;
                    }
                    swap(number, i, j);
                    reverse(number, j, number.length);
                }
            }
        return Arrays.copyOfRange(number, 0, k);
    }


    static void reverse(int[] permutation, int start, int end) {
        int shift = start + 1;
        for (int i = 0; i < (end - shift) / 2; i++) {
            swap(permutation,shift + i, end - i - 1);
        }
    }

    static  void swap(int[] permutation, int i, int k) {
        int temp = permutation[i];
        permutation[i] = permutation[k];
        permutation[k] = temp;
    }
}
