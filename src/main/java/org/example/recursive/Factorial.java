package org.example.recursive;

import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        int number = 5;
        System.out.println(factorial(number));
    }

    private static BigInteger factorial(int number) {
        if (number <= 1) {
            return new BigInteger("1");
        }
        return BigInteger.valueOf(number).multiply(factorial(number - 1));
    }
}
