package org.example.combinatorics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GenerationCombinationsLexicographicOrderTest {

    @Test
    void testGenerationCombinationsLexicographicOrder() {
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2, 4),
                Arrays.asList(1, 2, 5),
                Arrays.asList(1, 3, 4),
                Arrays.asList(1, 3, 5),
                Arrays.asList(1, 4, 5),
                Arrays.asList(2, 3, 4),
                Arrays.asList(2, 3, 5),
                Arrays.asList(2, 4, 5),
                Arrays.asList(3, 4, 5)
        );

        List<List<Integer>> result = GenerationCombinationsLexicographicOrder.generationCombinationsLexicographicOrder(5, 3);
        Assertions.assertEquals(expected, result);
    }
}