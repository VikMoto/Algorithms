package org.example.search;

public class LinearSearch {
    public static void main(String[] args) {
        int[] sequince = new int[] { -2, 0, 3, 5, 7, 9, 11, 15, 18, 21 };
        int element = 5;

        System.out.println(linearSearch(sequince, element));
    }

    private static int linearSearch(int[] sequince, int element) {
        for (int i = 0; i < sequince.length; i++) {
            if (sequince[i] == element) return i;
        }
        return -1;
    }
}
