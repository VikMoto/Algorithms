package org.example.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Description of the algorithm
 1) Create a sequence a of length m. Set a0 =n-m+1, other elements equal to 1. Go to 2.
 2) We return the sequence as a partition. Run test a1 < a0 -1 if it is
    condition is true go to 3, otherwise go to 4.
 3) Set a0 =a0 - 1, a1 =a1 + 1. Go to 2.
 4) Starting from the second element of the sequence, we are looking for an element
    that satisfies the condition aj <a0 -1. If no such element is found, we end the
    algorithm. Calculate the sum of all elements to the found element minus 1 (denoted as sum).
    Increase the value found element per unit. Let's move on to 5.
 5) We pass from the second element to the found element of the sequence. On
    at each step, set the value equal to the value of the found element, while
    decreasing the value of sum by this amount. After the pass is completed, set the value
    the first element of the sequence as sum. Go to 2.
 */
public class SplitNumberIntoMParts {
    public static void main(String[] args) throws InterruptedException {
        List<int[]> numberIntoMParts = splitNumberIntoMParts(8, 4);
        for (int[] numberIntoMPart : numberIntoMParts) {
            System.out.println(Arrays.toString(numberIntoMPart));
        }
    }
    public static List<int[]> splitNumberIntoMParts(int number, int m) throws InterruptedException {
        List<int[]> result = new ArrayList<>();

        int[] part = new int[m];
        Arrays.fill(part, 1);

        part[0] = number - m + 1;
        while (true) {
            result.add(Arrays.copyOf(part,part.length));
//            System.out.println(Arrays.toString(part));
            if (part[1] < part[0] - 1) {
                // point 3
                part[0] = part[0] - 1;
                part[1] = part[1] + 1;
            } else {
                 // point 4
                int end = -1;
                int sum = part[0] - 1;
                for (int i = 1; i < part.length; i++) {
                    if (part[i] < part[0] - 1) {
                        end = i;
                        break;
                    }
                    sum += part[i];
                }
                if (end == -1) {
                    break;
                }
                part[end] += 1;
                // point 5
                for (int i = 1; i < end; i++) {
                    //On at each step, set the value equal to the value of the found element
                    part[i] = part[end];
                    //while decreasing the value of sum by this amount
                    sum -= part[end];
                }
                part[0] = sum;
            }
        }
        return result;
    }
}
