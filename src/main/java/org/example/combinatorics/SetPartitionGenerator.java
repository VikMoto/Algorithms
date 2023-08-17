package org.example.combinatorics;

import java.util.*;

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
public class SetPartitionGenerator<T> implements Iterable<List<List<T>>>{
    private List<T> setSequence;
    public SetPartitionGenerator(List<T> setSequence) {
        super();
        this.setSequence = setSequence;
    }
    private class PartitionIterator implements Iterator<List<List<T>>> {
        private Iterator<int[]> iteratored =
                new ConstructingIncreasingSequenceNumbersFromSet(setSequence.size()).iterator();

        @Override
        public boolean hasNext() {
            return iteratored.hasNext();
        }

        @Override
        public List<List<T>> next() {
            if (iteratored.hasNext() == false) {
                throw new NoSuchElementException();
            }
            int[] part = iteratored.next();
//            System.out.println("Arrays.toString(part) = " + Arrays.toString(part));
            List<List<T>> result = new ArrayList<>();
            for (int i = 0; i < part.length; i++) {
                if (result.size() < part[i] + 1) {
                    result.add(new ArrayList<>());
                }
                result.get(part[i]).add(setSequence.get(i));
            }
            return result;
        }
    }

    @Override
    public Iterator<List<List<T>>> iterator() {
        return new PartitionIterator();
    }
}
