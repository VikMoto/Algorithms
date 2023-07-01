package org.example.memoization;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class MemoizationFunc {
    public static Map<Integer, BigInteger> mem = new HashMap<>();

    public static void main(String[] args) {

        BigInteger fac = factorial(15000);
        System.out.println(fac);
        fac = factorial(15000);
        System.out.println("mem = " + mem);

    }

    public static BigInteger factorial(int number) {
        BigInteger fact = mem.get(number);
        if (fact != null) {
            System.out.println("  in cash  ");
            return fact;
        } else {
            fact = BigInteger.ONE;
            for (int i = 1; i <= number; i++) {
                fact = fact.multiply(BigInteger.valueOf(i));
            }
            mem.put(number, fact);
            return fact;
        }
    }
}
