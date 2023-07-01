package org.example.recursive;

import java.util.ArrayList;
import java.util.List;

public class FlatLisOfLists {
    public static void main(String[] args) {
        List<?> input = List.of(55, List.of(1), List.of(5, List.of(777,444) ), List.of(9,2), List.of(6,77));

        List<Integer> result =  getElements(input, null);

        System.out.println("result = " + result);

    }

    private static List<Integer> getElements(List<?> input, List<Integer> result) {

        if (result == null) {
            result = new ArrayList<>();
        }
        for (Object o : input) {
            if (o instanceof List<?>) {
                getElements((List<?>)o, result);
            }else {
                result.add((Integer) o);
            }
        }
        return result;
    }
}
