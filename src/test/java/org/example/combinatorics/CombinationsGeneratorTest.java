package org.example.combinatorics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationsGeneratorTest {
    @Test
    public void testCombinationsGenerator() {
        List<List<Integer>> result = CombinationsGenerator.combinationsGenerator(5, 3);
        // Expected combinations for (5, 3) are [[0, 1, 2], [0, 1, 3], [0, 2, 3], [1, 2, 3], [0, 1, 4], [0, 2, 4], [1, 2, 4], [0, 3, 4], [1, 3, 4], [2, 3, 4]]
        Assertions.assertEquals(10, result.size());

        // Add more specific assertions to validate the generated combinations
        // For example, check individual combinations:
        Assertions.assertEquals(List.of(0, 1, 2), result.get(0));
        Assertions.assertEquals(List.of(0, 1, 3), result.get(1));
        Assertions.assertEquals(List.of(0, 2, 3), result.get(2));
        Assertions.assertEquals(List.of(1, 2, 3), result.get(3));
        Assertions.assertEquals(List.of(0, 1, 4), result.get(4));

    }
}