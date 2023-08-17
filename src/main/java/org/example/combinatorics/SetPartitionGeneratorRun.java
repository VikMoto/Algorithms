package org.example.combinatorics;

import java.util.List;

public class SetPartitionGeneratorRun {
    public static void main(String[] args) {
        List<String> setPartition = List.of("apple", "banana", "orange", "lemon");
        for (List<List<String>> lists : new SetPartitionGenerator<>(setPartition)) {
            System.out.println(lists);
        }
    }
}
/**
 [[apple, banana, orange, lemon]]
 [[apple, banana, orange], [lemon]]
 [[apple, banana, lemon], [orange]]
 [[apple, banana], [orange, lemon]]
 [[apple, banana], [orange], [lemon]]
 [[apple, orange, lemon], [banana]]
 [[apple, orange], [banana, lemon]]
 [[apple, orange], [banana], [lemon]]
 [[apple, lemon], [banana, orange]]
 [[apple], [banana, orange, lemon]]
 [[apple], [banana, orange], [lemon]]
 [[apple, lemon], [banana], [orange]]
 [[apple], [banana, lemon], [orange]]
 [[apple], [banana], [orange, lemon]]
 [[apple], [banana], [orange], [lemon]]
 */