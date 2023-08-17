package org.example.combinatorics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 Description of the algorithm

 1) We create a sequence of length n (n is the number of elements in the set) in the future
 let's denote it as partition. We fill it with zeros. Creating a Helper Sequence
 of size n (hereinafter support) we fill it with units. Let's move on to point 2.
 2) Return partition as result. Check if partition[n-1]==support[n-1]
 go to step 4 otherwise go to step 3.
 3) Set partition[n-1]=partition[n-1] + 1 and go to step 2.
 4) Starting from the penultimate element, perform a reverse pass to find the maximum
 index (hereinafter j) for which partition[j] ≠ support[j]. Go to point 5.
 5) If j==0, finish the algorithm. Otherwise install
 partition[j]=partition[j]+1. Go to point 6.

 6) Set support[n-1] = support[j]. If partition[j]==support[j] then set support[n-
 1]=support[n-1]+1. Set j=j+1. Starting from index j and up to index n-1 set partition[j]=0,

 support[j] = support[n-1]. Go to point 2.
 */
public class ConstructingIncreasingSequenceNumbersFromSet  implements Iterable<int[]>{
    int[] partition;
    int[] support;

    public ConstructingIncreasingSequenceNumbersFromSet(int n) {
        this.partition = new int[n];
        this.support = new int[n];
        filling();
    }
    private void filling() {
        for (int i = 0; i < partition.length; i++) {
            partition[i] = 0;
            support[i] = 1;
        }
    }
    public void nextStep() {
        int n = partition.length;

        //point 2
        if (partition[n - 1] != support[n - 1]) {
            //point 3
            partition[n - 1] += 1;
        } else  {
            int j = n - 2;
            //point 4
                for (; j > 0 && partition[j] == support[j];) {
                    j--;
                }
                //point 5
                if (j == 0){
                    partition = null;
                    return;
                }
                partition[j] += 1;

                //point 6
                    if (partition[j] == support[j]) {
                        support[n - 1] = support[j] + 1;
                    }else {
                        support[n - 1] = support[j];
                    }
                    for ( int k = j + 1 ; k < n; k++ ) {
                        partition[k] = 0;
                        support[k] = support[n - 1];
                    }
            }
    }

    private class PartitionIterator implements Iterator<int[]> {

        @Override
        public boolean hasNext() {
            return partition != null;
        }

        @Override
        public int[] next() {
            if (partition == null) {
                throw new NoSuchElementException();
            }
            int[] result = Arrays.copyOf(partition, partition.length);
            nextStep();
            return result;
        }
    }

    @Override
    public Iterator<int[]> iterator() {
        return new PartitionIterator();
    }
}
