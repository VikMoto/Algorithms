package org.example.combinatorics;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SplitNumberIntoMPartsTest {

    @Test
    public void testSplitNumberIntoMParts() throws InterruptedException {
        int number = 8;
        int m = 4;
        int[][] expected = {
                {5, 1, 1, 1},
                {4, 2, 1, 1},
                {3, 3, 1, 1},
                {3, 2, 2, 1},
                {2, 2, 2, 2}
        };

        List<int[]> actualPartitions = SplitNumberIntoMParts.splitNumberIntoMParts(number, m);

        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actualPartitions.get(i));
        }
    }
}






