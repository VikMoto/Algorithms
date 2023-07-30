package org.example.combinatorics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LexicographicPermutationsNarayanTest {

    @Test
    public void testPermutationGeneratorNarayan() {
        int n = 4;
        List<List<Integer>> actualPermutations =
                LexicographicPermutationsNarayan.permutationGeneratorNarayan(n);

        List<List<Integer>> expectedPermutations = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(1, 2, 4, 3),
                Arrays.asList(1, 3, 2, 4),
                Arrays.asList(1, 3, 4, 2),
                Arrays.asList(1, 4, 2, 3),
                Arrays.asList(1, 4, 3, 2),
                Arrays.asList(2, 1, 3, 4),
                Arrays.asList(2, 1, 4, 3),
                Arrays.asList(2, 3, 1, 4),
                Arrays.asList(2, 3, 4, 1),
                Arrays.asList(2, 4, 1, 3),
                Arrays.asList(2, 4, 3, 1),
                Arrays.asList(3, 1, 2, 4),
                Arrays.asList(3, 1, 4, 2),
                Arrays.asList(3, 2, 1, 4),
                Arrays.asList(3, 2, 4, 1),
                Arrays.asList(3, 4, 1, 2),
                Arrays.asList(3, 4, 2, 1),
                Arrays.asList(4, 1, 2, 3),
                Arrays.asList(4, 1, 3, 2),
                Arrays.asList(4, 2, 1, 3),
                Arrays.asList(4, 2, 3, 1),
                Arrays.asList(4, 3, 1, 2),
                Arrays.asList(4, 3, 2, 1)
        );
        Assertions.assertEquals(expectedPermutations.size(), actualPermutations.size());
        // Compare each permutation in the lists
        for (int i = 0; i < expectedPermutations.size(); i++) {
            List<Integer> expectedPerm = expectedPermutations.get(i);
            List<Integer> actualPerm = actualPermutations.get(i);
            Assertions.assertEquals(expectedPerm, actualPerm);
        }
    }
}