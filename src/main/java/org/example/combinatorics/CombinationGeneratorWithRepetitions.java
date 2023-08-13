package org.example.combinatorics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 How the algorithm works
 We generate all combinations with repetitions from n integers [0,1,2...n-1] by k.
 1)Create a sequence of k elements. Set the values to
 0. Go to 2.
 2) Return the resulting sequence. Let's move on to 3.
 3) Starting from the end of the sequence, we search for an element whose value
 less than n-1 (a[i]<n-1). If the search is unsuccessful, terminate the algorithm. Otherwise
 case, go to step 4.
 4) Increase the found element by one (a[i]=a[i]+1). Starting from next
 element and until the end of the sequence set the values equal to a[i]. Go to
 paragraph 2.
 */

public class CombinationGeneratorWithRepetitions<T> implements Iterable<T[]> {
    private int[] combination;
    private T[] sequence;
    private int numberOfElements;
    private int kCombinations;

    public CombinationGeneratorWithRepetitions( T[] sequence, int kCombinations) {
        super();
        this.combination = new int[kCombinations];
        this.kCombinations = kCombinations;
        this.numberOfElements = combination.length;
        this.sequence = Arrays.copyOf(sequence, numberOfElements);
    }

    private int[] nextCombination(int[] combination, int n) {
        int i = combination.length - 1;
        for (; i > -1 && combination[i] >= n - 1 ;) {
            i -= 1;
        }
        if (i == - 1) {
            return null;
        }
        combination[i] += 1;
        for (int j = i + 1; j < combination.length; j++) {
            combination[j] = combination[i];
        }
        return combination;
    }

    @Override
    public Iterator<T[]> iterator() {
        class CombinationIterator implements Iterator<T[]> {

            @Override
            public boolean hasNext() {
                return combination != null;
            }

            @Override
            public T[] next() {
                if (hasNext()) {
                    T[] result = Arrays.copyOf(sequence,kCombinations);
                    for (int i = 0; i < combination.length; i++) {
                        result[i] = sequence[combination[i]];
                    }
                    combination = nextCombination(combination, numberOfElements);
                    return result;
                } else {
                    throw new NoSuchElementException();
                }
            }
        }
        return new CombinationIterator();
    }
}
