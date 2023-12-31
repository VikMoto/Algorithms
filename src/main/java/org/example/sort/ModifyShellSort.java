 package org.example.sort;

import java.util.Arrays;

/**
 worst time Sort O(n2)
 best time of sort O(n*log(N))
 Memory O(n)
 Rule for finding position for element with value X:
 an ≤ X ≤ an+h
 h - step
 * */
interface StepGenerator {
    public int nextStep();
}

 class ShellStep implements StepGenerator {
     private int step;

     public ShellStep(int[] array) {
         step = array.length / 2;
     }

     @Override
     public int nextStep() {
         step = step / 2;
         return step;
     }

 }

 class HibbardStep implements StepGenerator {
     private int i;

     public HibbardStep(int[] array) {
         for (; (int) (Math.pow(2, i) - 1) < array.length;) {
             i += 1;
         }
     }

     @Override
     public int nextStep() {
         i = i - 1;
         return (int) (Math.pow(2, i) - 1);
     }

 }

 class SedgewickStep implements StepGenerator {
     private int i;

     public SedgewickStep(int[] array) {
         long number = (long) (9 * (Math.pow(2, i) - Math.pow(2, i / 2)) + 1);
         for (; number < array.length;) {
             i += 1;
             if (i % 2 == 0) {
                 number = (long) (9 * (Math.pow(2, i) - Math.pow(2, i / 2)) + 1);
             } else {
                 number = (long) (8 * Math.pow(2, i) - 6 * Math.pow(2, (i + 1) / 2) + 1);
             }
         }
     }

     @Override
     public int nextStep() {
         i = i - 1;
         if (i <= -1) {
             return 0;
         }
         if (i % 2 == 0) {
             return (int) (9 * (Math.pow(2, i) - Math.pow(2, i / 2)) + 1);
         } else {
             return (int) (8 * Math.pow(2, i) - 6 * Math.pow(2, (i + 1) / 2) + 1);
         }
     }

 }

 class KnuthStep implements StepGenerator {
     private int i;
     public KnuthStep(int[] array) {
         for (; (Math.pow(3, i) - 1) / 2 < array.length / 3;) {
             i = i + 1;
         }
     }

     @Override
     public int nextStep() {
         int step = (int) ((Math.pow(3, i) - 1) / 2);
         i = i - 1;
         return step;
     }

 }
public class ModifyShellSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 0, -2, 7, 3};
        int step = array.length / 2;

        shellSort(array, new KnuthStep(array));
        System.out.println(Arrays.toString(array));
    }

    private static void shellSort(int[] array, StepGenerator stepGen) {
        int step = stepGen.nextStep();
        while (step > 0) {
            for (int i = step; i < array.length; i++) {
                int j = i;
                while (j >= step && array[j] < array[j - step]) {
                    int temp = array[j];
                    array[j] = array[j - step];
                    array[j - step] = temp;
                    j -= stepGen.nextStep();
                }
            }
            step = step / 2;
        }
    }
}
