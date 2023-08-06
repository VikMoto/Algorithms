package org.example.combinatorics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
