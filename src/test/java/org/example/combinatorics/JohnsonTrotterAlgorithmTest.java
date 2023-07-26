package org.example.combinatorics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JohnsonTrotterAlgorithmTest {
    @Test
    public void testPermutationGenerator() {
        // Test for number = 3
        JohnsonTrotterAlgorithm.permutationGenerator(3);
        // Since the method prints the permutations, there's no direct output to check.
        // We can manually verify that it generates all the possible permutations of 1, 2, and 3.
        // The output can be seen in the console when running the test.
        // Additional tests can be added for other cases if needed.
    }

    @Test
    public void testFindMaxMobileElement() {
        // Test case with a mobile element
        int[] permutation1 = {3, 1, 2};
        int[] direction1 = {-1, -1, -1};
        int expectedIndex1 = 2;
        int actualIndex1 = JohnsonTrotterAlgorithm.findMaxMobileElement(permutation1, direction1);
        Assertions.assertEquals(expectedIndex1, actualIndex1);

        // Test case without a mobile element
        int[] permutation2 = {2, 1, 3};
        int[] direction2 = {-1, -1, 1};
        int expectedIndex2 = -1;
        int actualIndex2 = JohnsonTrotterAlgorithm.findMaxMobileElement(permutation2, direction2);
        Assertions.assertEquals(expectedIndex2, actualIndex2);
    }

    @Test
    public void testChangeDirection() {
        // Test case where mobileElement = 2
        int[] permutation = {3, 1, 2};
        int[] direction = {-1, -1, -1};
        int mobileElement = 2;
        JohnsonTrotterAlgorithm.changeDirection(permutation, direction, mobileElement);

        int[] expectedPermutation1 = {3, 2, 1};
        int[] expectedDirection1 = {1, -1, -1};
        Assertions.assertArrayEquals(expectedDirection1, direction);
        JohnsonTrotterAlgorithm.swap(permutation,direction,2,1);

        // Test case where mobileElement = 3
        int[] permutation2 = {3, 2, 1};
        int[] direction2 = {1, -1, -1};
        int mobileElement2 = 3;
        JohnsonTrotterAlgorithm.changeDirection(permutation2, direction2, mobileElement2);
        JohnsonTrotterAlgorithm.swap(permutation2,direction2,0,1);

        int[] expectedPermutation2 = {2, 3, 1};
        int[] expectedDirection2 = {-1, 1, -1};
        Assertions.assertArrayEquals(expectedPermutation2, permutation2);
        Assertions.assertArrayEquals(expectedDirection2, direction2);
    }
}