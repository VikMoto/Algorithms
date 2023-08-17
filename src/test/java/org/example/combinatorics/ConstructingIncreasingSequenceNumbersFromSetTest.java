package org.example.combinatorics;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ConstructingIncreasingSequenceNumbersFromSetTest {

    @Test
    public void testIterator() {
        ConstructingIncreasingSequenceNumbersFromSet sequenceGenerator =
                new ConstructingIncreasingSequenceNumbersFromSet(3);
        int[][] expected = {
                {0, 0, 0},
                {0, 0, 1},
                {0, 1, 0},
                {0, 1, 1},
                {0, 1, 2}
        };

        int index = 0;
        for (int[] actual : sequenceGenerator) {
            assertArrayEquals(expected[index], actual);
            index++;
        }

        assertFalse(sequenceGenerator.iterator().hasNext());
    }
}
