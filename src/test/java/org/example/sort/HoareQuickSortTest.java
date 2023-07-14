package org.example.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class HoareQuickSortTest {
    @Test
    public void testHoareQuickSort() {
        int[] array = new int[]{5, 0, -2, 7, 3};
        int[] expected = new int[]{-2, 0, 3, 5, 7};

        HoareQuickSort.hoareQuickSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testBreakPartition() {
        int[] array = new int[]{5, 0, -2, 7, 3};
        int expected = 2;

        int result = HoareQuickSort
                .breakPartition(array, 0, array.length - 1);
        assertEquals(expected, result);
    }
}
