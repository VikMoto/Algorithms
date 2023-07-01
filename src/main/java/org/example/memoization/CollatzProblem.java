package org.example.memoization;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class CollatzProblem {
    public static Map<BigInteger, BigInteger> mem = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("5000000000 " + getSequinceLength(BigInteger.valueOf(5000000000L)));
        System.out.println(mem);
        System.out.println("15000000000 " + getSequinceLength(BigInteger.valueOf(15000000000L)));

    }

    public static BigInteger getSequinceLength(BigInteger number) {
        BigInteger result = mem.get(number);
        if (result != null) {
            return result;
        }
        if (number.equals(BigInteger.ONE)) {
            mem.put(number, BigInteger.ZERO);
        } else {
            BigInteger newNumber = null;
            if (number.remainder(BigInteger.TWO).equals(BigInteger.ZERO)) {
                newNumber = number.divide(BigInteger.TWO);
            } else {
                newNumber = number.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE);
            }
            result = BigInteger.ONE.add(getSequinceLength(newNumber));
            mem.put(number, result);
        }
        return mem.get(number);
    }
}
