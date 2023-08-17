package org.example.combinatorics;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class BellTriangleTest {

    @Test
    public void testGenerateTriangleBell() {
        BigInteger[][] expected = {
                {BigInteger.ONE},
                {BigInteger.ONE, BigInteger.TWO},
                {BigInteger.valueOf(2), BigInteger.valueOf(3), BigInteger.valueOf(5)},
                {BigInteger.valueOf(5), BigInteger.valueOf(7), BigInteger.valueOf(10), BigInteger.valueOf(15)},
                {BigInteger.valueOf(15), BigInteger.valueOf(20), BigInteger.valueOf(27), BigInteger.valueOf(37), BigInteger.valueOf(52)},
                // ... Add more expected rows for further testing
        };

        BigInteger[][] result = BellTriangle.generateTriangleBell(expected.length - 1);

        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], result[i]);
        }
    }

    @Test
    public void testGenerateBellNumbers() {
        BigInteger[] expected = {
                BigInteger.ONE,
                BigInteger.ONE,
                BigInteger.valueOf(2),
                BigInteger.valueOf(5),
                BigInteger.valueOf(15),
                // ... Add more expected values for further testing
        };

        BigInteger[] result = BellTriangle.generateBellNumbers(expected.length - 1);

        assertArrayEquals(expected, result);
    }
}
