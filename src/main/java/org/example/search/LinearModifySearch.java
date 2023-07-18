package org.example.search;

import java.util.ArrayList;
import java.util.List;

public class LinearModifySearch {
    public static void main(String[] args) {
        int[] arrs = new int[] { -2, 0, 4, 3, 7, 9, 11, 15, 18, 21 };
        int element = 5;
        List<Integer> sequince = new ArrayList<>();
        for (int arr : arrs) {
            sequince.add(arr);
        }


        System.out.println(linearModifySearch(sequince, element));
    }

    private static int linearModifySearch(List<Integer> sequince, int element) {
        sequince.add(element);
        int lastIndex = sequince.size() - 1;
        int i = 0;
        while (sequince.get(i) != element) {
            i++;
        }
        sequince.remove(element);
        if (i != lastIndex) return i;
        return -1;
    }
}
