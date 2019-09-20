package org.algo.com;

public class MergeSort {

    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 55, 7, 1, -22  };

        mergeSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i]+"\t");
        }
    }

    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void mergeSort(int[] input, int start, int end) {
    	          	
        if (end - start < 2) {
            return;
        }
        
        for(int a: input) {
    		System.out.print(TextColor.ANSI_BLACK+a+"\t");
        }
    	System.out.println("\n");

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void merge(int[] input, int start, int mid, int end) {
    	
        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;
        System.out.println("i: "+i+" start: "+start+" tempIndex: "+tempIndex+" mid: "+mid+
        		" End: "+end+"\n");
        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        System.out.println("\nCopying into left over array");
        System.out.println("i: "+i+" start: "+start+" tempIndex: "+tempIndex+" mid: "+mid+
        		" End: "+end+"\n");
        for(int a: input) {
    		System.out.print(TextColor.ANSI_BLUE+a+"\t");
    	}
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.out.println("\n");
        for(int a: input) {
    		System.out.print(TextColor.ANSI_BLUE+a+"\t");
    	}
        System.out.println("\n\nCopying into Temp Array.");
        System.arraycopy(temp, 0, input, start, tempIndex);
        for(int a: temp) {
    		System.out.print(TextColor.ANSI_GREEN+a+"\t");
    	}
        System.out.println("\n");
        for(int a: input) {
    		System.out.print(TextColor.ANSI_BLUE+a+"\t");
    	}
    	System.out.println("\n");

    }

}
