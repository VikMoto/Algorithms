package org.example.combinatorics;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RevolvingDoorCombinationTest {

    @Test
    public void testRevolvingDoorCombination() {
        // Define the expected result for the given inputs (5, 3)
        List<List<Integer>> expectedCombination = List.of(
                List.of(0, 1, 2),
                List.of(0, 2, 3),
                List.of(1, 2, 3),
                List.of(0, 1, 3),
                List.of(0, 3, 4),
                List.of(1, 3, 4),
                List.of(2, 3, 4),
                List.of(0, 2, 4),
                List.of(1, 2, 4),
                List.of(0, 1, 4)
        );

        // Call the revolvingDoorCombination method with the given inputs (5, 3)
        List<List<Integer>> doorCombination = RevolvingDoorCombination.revolvingDoorCombination(5, 3);

        // Assert that the actual result matches the expected result
        assertEquals(expectedCombination, doorCombination);
    }
}