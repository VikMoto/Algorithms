package org.example.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LomutoQuickSortTest {

    @Test
    void testLomutoQuickSort() {
        int[] array = {5, 0, -2, 7, 3};
        int[] expected = {-2, 0, 3, 5, 7};

        LomutoQuickSort.lomutoQuickSort(array);

        assertArrayEquals(expected, array);
    }
}