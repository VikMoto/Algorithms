package org.example.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class MergeRecursiveSortTest {
    @Test
    public void testMergeRecursiveSort() {
        int[] array = new int[]{5, 0, -2, 7, 3};
        int[] expected = new int[]{-2, 0, 3, 5, 7};

        MergeRecursiveSort.mergeRecursiveSort(array);
        assertArrayEquals(expected, array);
    }
}
