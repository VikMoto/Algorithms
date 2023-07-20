package org.example.search;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TernarySearchTest {
    @Test
    void testTernarySearch() {
        int[] sequence = new int[]{-2, 0, 3, 5, 7, 9, 11, 15, 18, 21};

        // Test for existing elements
        assertEquals(0, TernarySearch.ternarySearch(sequence, -2));
        assertEquals(3, TernarySearch.ternarySearch(sequence, 5));
        assertEquals(9, TernarySearch.ternarySearch(sequence, 21));

        // Test for non-existing elements
        assertEquals(-1, TernarySearch.ternarySearch(sequence, 4));
        assertEquals(-1, TernarySearch.ternarySearch(sequence, 14));
        assertEquals(-1, TernarySearch.ternarySearch(sequence, 25));
    }

}