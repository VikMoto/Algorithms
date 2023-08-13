package org.example.combinatorics;

import java.util.ArrayList;
import java.util.List;
/**
 How the algorithm works
 We generate all combinations of n integers [0,1,2...n-1] by k.
 1) Create a sequence of k + 1 elements (hereinafter c). First k - elements
    set equal to the element index. Element k+1 is set equal to n-1. Enter
    additional variable j. Go to 2.
 2) We return the first k elements of the sequence as the next combination. Go to 3.
 3) Two options are possible:
 - k is odd. If c0 + 1 < c1 set c0 = c0 + 1 go to 2. Otherwise set j = 1 and go to 4.
 - k is even. If c0 >0 set c0 = c0 - 1 go to 2. Otherwise set j = 1 and go to 5.
 4) In case cj >j install cj = cj-1, cj-1 = j-1 and go to 2. Otherwise,
    set j = j + 1 and go to 5.
 5) If cj +1 <= cj+1 set cj-1 = cj , cj = cj + 1 and go to 2. Otherwise,
    set j = j + 1, if j<k go to 4. Otherwise, terminate the algorithm.
 */

public class RevolvingDoorCombination {
    public static void main(String[] args) {
        List<List<Integer>> doorCombination = revolvingDoorCombination(5, 3);
        System.out.println("doorCombination = " + doorCombination);

    }

    static List<List<Integer>> revolvingDoorCombination(int number, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        int[] supportSequence = generateSupportSequence(number, k);
        int j = 1;
        int step = 2;

        while (step != -1) {
            //2 point
            switch (step) {
                case 2:
                    combination = addCombinationRevolver(supportSequence);
                    result.add(combination);
                    step = 3;
                    break;
                case 3:
                    int[] res3 = checkFirstElement(supportSequence,k);
                    step = res3[0];
                    j = res3[1];
                    break;
                case 4:
                int[] res4 = decreaseElement(supportSequence, j);
                    step = res4[0];
                    j = res4[1];
                    break;
                case 5:
                int[] res5 = enlargementElement(supportSequence, j, k);
                    step = res5[0];
                    j = res5[1];
                    break;
            }
        }
        return result;
    }

    private static int[] checkFirstElement(int[] comb, int k) {
        //step 3
        int step = 0;
        int j = 1;
        //3-1point
        if (k % 2 != 0) {
            if (comb[0]+ 1 < comb[1]) {
                comb[0] += 1;
                step = 2;
            } else {
                step = 4;
            }
        }
        //3-2 point
        if (k % 2 == 0) {
            if (comb[0] > 0 ) {
                comb[0] -= 1;
                step = 2;
            } else {
                step = 5;
            }
        }
        return new int[]{step, j};
    }

    private static int[] decreaseElement(int[] supportSequence, int j) {
        // 4 point
        int step;
        if(supportSequence[j] > j) {
            supportSequence[j] = supportSequence[j - 1];
            supportSequence[j - 1] = j - 1;
            step = 2;
        } else {
            j += 1;
            step = 5;
        }
        return new int[]{step, j};
    }

    private static int[] enlargementElement(int[] supportSequence, int j, int k) {
        int step;
        //5 point
        if(supportSequence[j] + 1 <= supportSequence[j + 1]) {
            supportSequence[j - 1] = supportSequence[j];
            supportSequence[j]++ ;
            step = 2;
        } else {
           j++;
           if (j < k) {
               step = 4;
           } else {
               step = -1;
           }
        }
        return new int[]{step, j};
    }
    private static List<Integer> addCombinationRevolver(int[] supportSequence) {
        List<Integer> combination = new ArrayList<>();
        for (int j = 0; j < supportSequence.length - 1; j++) {
            combination.add(supportSequence[j]);
        }
        return combination;
    }
    private static int[] generateSupportSequence(int number, int k) {
        int[] comb = new int[k + 1];
        for (int i = 0; i < k; i++) {
            comb[i] = i;
        }
        comb[comb.length - 1] = number - 1;
        return comb;
    }
}
