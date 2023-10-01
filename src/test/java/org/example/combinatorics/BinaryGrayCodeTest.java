package org.example.combinatorics;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryGrayCodeTest {

    @Test
    public void testBinaryGrayCode() {
        List<List<Integer>> result = BinaryGrayCode.binaryGrayCode(3);
        assertEquals(8, result.size()); // There should be 2^n combinations for n bits

        // Here you can write assertions to check specific combinations if needed
        // For example, to check the last combination [1, 0, 0]
        List<Integer> lastCombination = result.get(7);
        assertEquals(3, lastCombination.size());
        assertEquals(1, (int) lastCombination.get(0));
        assertEquals(0, (int) lastCombination.get(1));
        assertEquals(0, (int) lastCombination.get(2));
        // Add more assertions for other combinations if needed
    }
}
