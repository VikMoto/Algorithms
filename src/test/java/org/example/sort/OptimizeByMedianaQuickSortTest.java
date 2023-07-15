package org.example.sort;

import org.junit.jupiter.api.Test;

import static org.example.sort.OptimizeByMedianaQuickSort.medaina;
import static org.junit.jupiter.api.Assertions.*;

class OptimizeByMedianaQuickSortTest {

    @Test
    void medainaTest() {
        int[] array = {5, 0, -2, 7, 3};
        int iStart = 0;
        int iMid = 2;
        int iEnd = 4;
        int expectedIndex = 4;

        int resultIndex = medaina(array, iStart, iMid, iEnd);

        assertEquals(expectedIndex, resultIndex);
    }
}