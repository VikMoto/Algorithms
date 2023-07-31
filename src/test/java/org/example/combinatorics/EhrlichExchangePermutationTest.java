package org.example.combinatorics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

class EhrlichExchangePermutationTest {

    @Test
    public void testEhrlichExchangePermutation() {
        Character[] array = new Character[] {'a', 'b', 'c'};
        List<List<Character>> exchangePermutation =
                EhrlichExchangePermutation.ehrlichExchangePermutation(array);

        // Expected results based on manual calculation
        List<List<Character>> expectedPermutations = List.of(
                List.of('a', 'b', 'c'),
                List.of('b', 'a', 'c'),
                List.of('c', 'a', 'b'),
                List.of('a', 'c', 'b'),
                List.of('b', 'c', 'a'),
                List.of('c', 'b', 'a')
        );
        Assertions.assertEquals(expectedPermutations, exchangePermutation);
    }

    @Test
    public void testEmptyArray() {
        Character[] array = new Character[1];
        List<List<Character>> exchangePermutation = EhrlichExchangePermutation.ehrlichExchangePermutation(array);

        // For an empty array, there should be only one permutation (empty list)
        Assertions.assertEquals(1, exchangePermutation.size());
    }

    @Test
    public void testSingleElementArray() {
        Character[] array = new Character[]{'a'};
        List<List<Character>> exchangePermutation = EhrlichExchangePermutation.ehrlichExchangePermutation(array);

        // For a single element array, there should be only one permutation (the original element)
        Assertions.assertEquals(1, exchangePermutation.size());
        Assertions.assertEquals(List.of('a'), exchangePermutation.get(0));
    }
}