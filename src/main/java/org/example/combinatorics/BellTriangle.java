package org.example.combinatorics;

import java.math.BigInteger;
import java.util.Arrays;

public class BellTriangle {
    public static void main(String[] args) {

        BigInteger[][] bellNumbers = generateTriangleBell(10);

        for (BigInteger[] bellNumber : bellNumbers) {
            System.out.println(Arrays.toString(bellNumber));
        }

        BigInteger[] generateBellNumbers = generateBellNumbers(20);

        System.out.println(Arrays.toString(generateBellNumbers));
    }

    public static BigInteger[][] generateTriangleBell(int n) {
        BigInteger[][] result = new BigInteger[n + 1][];
        BigInteger[] previousRow = new BigInteger[]{ BigInteger.ONE };
        result[0] = previousRow;

        for (int i = 1; i <= n ; i++) {
            BigInteger[] currentRow = new BigInteger[i + 1];
            currentRow[0] = previousRow[previousRow.length-1];
            for (int j = 1; j < currentRow.length; j++) {
                currentRow[j] = previousRow[j - 1].add(currentRow[j - 1]);
            }
            result[i] = currentRow;
            previousRow = currentRow;
        }
        return result;
    }

    public static BigInteger[] generateBellNumbers(int n) {
        BigInteger[] result = new BigInteger[n + 1];
        BigInteger[] previousRow = new BigInteger[]{ BigInteger.ONE };
        result[0] = previousRow[previousRow.length - 1];

        for (int i = 1; i <= n ; i++) {
            BigInteger[] currentRow = new BigInteger[i + 1];
            currentRow[0] = previousRow[previousRow.length-1];
            for (int j = 1; j < currentRow.length; j++) {
                currentRow[j] = previousRow[j - 1].add(currentRow[j - 1]);
            }
            result[i] = currentRow[0];
            previousRow = currentRow;
        }
        return result;
    }
}
