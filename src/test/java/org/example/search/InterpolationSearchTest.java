package org.example.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterpolationSearchTest {
    @Test
    public void testInterpolationSearch() {
        int[] sequence = { -2, 0, 3, 5, 7, 9, 11, 15, 18, 21 };
        assertEquals(7, InterpolationSearch.interpolationSearch(sequence, 15));

        // Test with elements not present in the array
        assertEquals(-1, InterpolationSearch.interpolationSearch(sequence, 8));
        assertEquals(-1, InterpolationSearch.interpolationSearch(sequence, -3));

        // Test with elements at the beginning and end of the array
        assertEquals(0, InterpolationSearch.interpolationSearch(sequence, -2));
        assertEquals(9, InterpolationSearch.interpolationSearch(sequence, 21));

        // Test with an empty array
        int[] emptySequence = {};
        assertEquals(-1, InterpolationSearch.interpolationSearch(emptySequence, 10));
    }

    @Test
    public void testInterpolationSearchWithDuplicates() {
        int[] sequence = { -2, 3, 5, 5, 5, 7, 11, 15, 18, 21 };
        assertEquals(2, InterpolationSearch.interpolationSearch(sequence, 5));
        assertEquals(6, InterpolationSearch.interpolationSearch(sequence, 11));

        // Test with element not present in the array
        assertEquals(-1, InterpolationSearch.interpolationSearch(sequence, 10));
    }

}