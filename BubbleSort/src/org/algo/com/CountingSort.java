package org.algo.com;

public class CountingSort {

    public static void main(String[] args) {
        int[] intArray = { 2, 5, 9, 8, 2, 8, 7, 10, 4, 3 };

        countingSort(intArray, 1, 10);

        for (int i = 0; i < intArray.length; i++) {
            System.out.print(TextColor.ANSI_CYAN+intArray[i]+"  ");
        }
    }

    public static void countingSort(int[] input, int min, int max) {

        int[] countArray = new int[(max - min) + 1];

        for (int i = 0; i < input.length; i++) {
            countArray[input[i] - min]++;
        }

        for(int k: countArray) {
        	System.out.print(TextColor.ANSI_GREEN+ k+ "  ");
        }
        System.out.println("\n");
        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countArray[i - min] > 0) {
            	System.out.println("Entered while loop. ith value is "+i+" input[j++]: "+j+
            			" and value: "+i);
                input[j++] = i;
                countArray[i - min]--;
            }
        }
      System.out.println("\n");
    }
}
