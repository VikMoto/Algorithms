package org.example.sort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeIteratorSortTest {
    @Test
    public void testMergeIteratorSort() {
        int[] sequence = new int[]{5, 0, -2, 7, 3};
        int[] expected = new int[]{-2, 0, 3, 5, 7};
        MergeIteratorSort.mergeIteratorSort(sequence);
        assertArrayEquals(expected, sequence);
    }
}
