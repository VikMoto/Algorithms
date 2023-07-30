package org.example.combinatorics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CyclicPermutationTest {
    @Test
    public void testLeftShiftClassic() {
        int[] array = {0, 1, 2, 3};
        int k = 2;
        CyclicPermutation.leftShiftClassic(array, k);
        int[] expectedArray = {1, 2, 0, 3};
        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testCyclicPermutationClassic() {
        int n = 4;
        List<List<Integer>> actualPermutations =
                CyclicPermutation.cyclicPermutationClassic(n);

        // Define expected permutations and compare
        List<List<Integer>> expectedPermutations = Arrays.asList(
                Arrays.asList(0, 1, 2, 3),
                Arrays.asList(1, 2, 3, 0),
                Arrays.asList(2, 3, 0, 1),
                Arrays.asList(3, 0, 1, 2),
                Arrays.asList(1, 2, 0, 3),
                Arrays.asList(2, 0, 3, 1),
                Arrays.asList(0, 3, 1, 2),
                Arrays.asList(3, 1, 2, 0),
                Arrays.asList(2, 0, 1, 3),
                Arrays.asList(0, 1, 3, 2),
                Arrays.asList(1, 3, 2, 0),
                Arrays.asList(3, 2, 0, 1),
                Arrays.asList(1, 0, 2, 3),
                Arrays.asList(0, 2, 3, 1),
                Arrays.asList(2, 3, 1, 0),
                Arrays.asList(3, 1, 0, 2),
                Arrays.asList(0, 2, 1, 3),
                Arrays.asList(2, 1, 3, 0),
                Arrays.asList(1, 3, 0, 2),
                Arrays.asList(3, 0, 2, 1),
                Arrays.asList(2, 1, 0, 3),
                Arrays.asList(1, 0, 3, 2),
                Arrays.asList(0, 3, 2, 1),
                Arrays.asList(3, 2, 1, 0)
        );
        // Check the number of permutations
        assertEquals(expectedPermutations.size(), actualPermutations.size());

        for (int i = 0; i < expectedPermutations.size(); i++) {
            List<Integer> expectedPerm = expectedPermutations.get(i);
            List<Integer> actualPerm = actualPermutations.get(i);
            Assertions.assertEquals(expectedPerm, actualPerm);
        }
    }
}