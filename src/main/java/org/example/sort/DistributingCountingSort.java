package org.example.sort;

import java.util.Arrays;

/**
 worst time Sort O(n)
 Constrain - only Integer Numbers in not big range (additional memory for n keys)

 Memory 2*range
 * */
public class DistributingCountingSort {
    public static void main(String[] args) {

        Cat[] cats = new Cat[]{
                new Cat("Vaska", 2),
                new Cat("Umka", 12),
                new Cat("Luska", 6),
                new Cat("Kuzia", 4),
                new Cat("Murka", 5),
                new Cat("Barsik", 6)

        };
        System.out.println(Arrays.toString(cats));

        distributionCountingSort(cats);
    }

    private static Cat[] distributionCountingSort(Cat[] cats) {
        int[] minMax = findMinMax(cats);
        int min = minMax[0];
        int max = minMax[1];
        int[] support = new int[(max - min) + 1];
        int indexHelpArr = 0;

        //create support Array
        for (int i = 0; i < cats.length; i++) {
            indexHelpArr = cats[i].getAge() - min;
            support[indexHelpArr] += 1;
        }
        int size = cats.length;
        System.out.println(Arrays.toString(support));

        //distribution counting
        for (int i = support.length - 1; i >=0 ; i--) {
            int currentElement = support[i];
            support[i] = size - currentElement;
            size = size - currentElement;
        }
        System.out.println(Arrays.toString(support));
        int indexOuter = 0;

//        create sorting Array
        Cat[] sortCats = new Cat[cats.length];
        int index = 0;
        for (int i = 0; i < cats.length; i++) {
            index = support[cats[i].getAge() - min ];
            sortCats[index] = cats[i];
            support[cats[i].getAge() - min] += 1;
        }
        System.out.println(Arrays.toString(sortCats));
        return sortCats;
    }

    private static int[] findMinMax(Cat[] array) {
        int min = array[0].getAge();
        int max = array[0].getAge();
        for (Cat element : array) {
            if (min > element.getAge()) {
                min = element.getAge();
            }
            if (max < element.getAge()) {
                max = element.getAge();
            }
        }
        return new int[] { min, max };
    }
}

