package org.example.sort;

import java.util.Arrays;

public class SortUserType {
    public static void main(String[] args) {


        Cat cat1 = new Cat("Umka", 5);
        Cat cat2 = new Cat("Timka", 3);
        Cat cat3 = new Cat("Vaska", 6);
        Cat cat4 = new Cat("Luska", 2);
        Cat cat5 = new Cat("Nuska", 7);
        Cat[] cats = new Cat[]{cat1, cat2, cat3, cat4, cat5};
        System.out.println("cats = " + Arrays.toString(cats));

        for (int i = 0; i < cats.length -1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < cats.length; j++) {
                int compare = compareCat(cats[minIndex], cats[j]);
                if(compare > 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Cat temp = cats[i];
                cats[i] = cats[minIndex];
                cats[minIndex] = temp;
            }
        }

        System.out.println("cats = " + Arrays.toString(cats));


    }
    private static int compareCat(Cat catOne, Cat catTwo) {
        if (catOne != null && catTwo == null) return 1;
        if (catOne == null && catTwo != null) return -1;
        if (catOne == null && catTwo == null) return 0;

        if (catOne.getAge() > catTwo.getAge()) return 1;
        if (catOne.getAge() < catTwo.getAge()) return -1;
        else return 0;
    }
}
