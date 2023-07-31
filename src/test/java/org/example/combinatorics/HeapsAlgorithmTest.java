package org.example.combinatorics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeapsAlgorithmTest {
    @Test
    void testHeapsAlgorithmPermutation() {
        // Test data
        Character[] array = new Character[]{'a', 'b', 'c'};
        List<List<Character>> expected = Arrays.asList(
                Arrays.asList('a', 'b', 'c'),
                Arrays.asList('b', 'a', 'c'),
                Arrays.asList('c', 'a', 'b'),
                Arrays.asList('a', 'c', 'b'),
                Arrays.asList('b', 'c', 'a'),
                Arrays.asList('c', 'b', 'a')
        );

        List<List<Character>> result = new ArrayList<>();
        HeapsAlgorithm.heapsAlgorithmPermutation(array, array.length, result);
        assertEquals(expected, result);
    }
}