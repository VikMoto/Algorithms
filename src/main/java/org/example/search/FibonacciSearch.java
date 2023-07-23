package org.example.search;

import org.example.sort.ThreeWayQuickSort;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**

 k - index searching element
 Average performance	O(log k
 */
public class FibonacciSearch {
    private int i;
    private int p;
    private int q;
    private boolean stop = false;
    public static Map<Integer, BigInteger> mem = new HashMap<>();

    public static void main(String[] args) {
        int[] sequince = new int[] { -2, 0, 3, 5, 7, 9, 11, 15, 18, 21 };
        ThreeWayQuickSort.threeWayQuickSort(sequince);
        System.out.println(Arrays.toString(sequince));
        FibonacciSearch fibonacciSearch = new FibonacciSearch();

        int element = 7;
        System.out.println("fibonachySearch " + fibonacciSearch.fibonacciSearch(sequince, element));

    }

    public static long getFibonacciNumber(Integer k){
        BigInteger kMem = mem.get(k);
        if (kMem != null) {
            System.out.println("in cash ");
            System.out.println("mem = " + mem);
            return kMem.longValue();
        }
        int firstNumber = 0;
        int secondNumber = 1;
        int n = 0;
        for (int i = 0; i < k; i++) {
            int tempNumber = secondNumber;
            secondNumber = firstNumber + secondNumber;
            firstNumber = tempNumber;
        }
        mem.put(k,BigInteger.valueOf(firstNumber));
        return firstNumber;
    }

    private void init(int[] sequince){
        stop = false;
        int k = 0;
        int n = sequince.length;
        for (; getFibonacciNumber(k + 1) < n + 1;) {
            k++;
        }
        long m = getFibonacciNumber(k + 1) - (n + 1);
        i = (int) (getFibonacciNumber(k) - m);
        p = (int) (getFibonacciNumber(k - 1));
        q = (int) (getFibonacciNumber(k - 2));

    }

    private void downIndex(){
        if (q == 0) return;
        i = i - q;
        int temp = p;
        p = q;
        q = temp - q;
    }

    private void upIndex(){
        if (p == 1) return;;
        i = i + q;
        p = p - q;
        q = q - p;
    }


    public int fibonacciSearch(int[] sequince, int element){
        init(sequince);
        int n = sequince.length;
        int resultIndex = -1;
        while (!stop) {
            if (i < 0) upIndex();
            else if (i >= n) downIndex();
            else if (sequince[i] == element) {
                 resultIndex = i;
                 break;
            } else if (element < sequince[i]) {
                downIndex();
            } else if (element > sequince[i]) {
                upIndex();
            }
        }
        return resultIndex;
    }


}
