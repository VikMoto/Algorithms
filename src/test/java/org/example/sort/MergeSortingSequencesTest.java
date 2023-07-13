package org.example.sort;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortingSequencesTest {
    @Test
    public void testMergeSortingSequence() {
        int[] array = new int[]{1, 3, 6, 9};
        int[] array2 = new int[]{2, 4, 4, 7};
        int[] expected = new int[]{1, 2, 3, 4, 4, 6, 7, 9};
        assertArrayEquals(expected,
                MergeSortingSequences.mergeSortingSequence(array, array2));
    }
}
