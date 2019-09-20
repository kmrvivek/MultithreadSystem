package org.algo.com;

public class ShellSort {

	public static void main(String[] args) {
		int[] intArray = {20, 35, -15, 7, 55, 1, -22 };

		for(int gap = intArray.length / 2; gap > 0; gap /= 2) {
			
			System.out.println(TextColor.ANSI_BLUE + "Main gap iteration. And gap now : "+ gap+". Check below for new main iteration\n\n");
			
			for(int i = gap; i < intArray.length; i++) {
				int newElement = intArray[i];
				System.out.println(TextColor.ANSI_GREEN +"Inner iteration start. Current element selected to start checking: "+newElement);
				
				int j = i;
				
				while(j >= gap && intArray[j - gap] > newElement) {
					System.out.println(TextColor.ANSI_RED+ "In while loop for swap insertion. "
							+ "Selected element of index: "+j+" and element is: "+intArray[j]+
							" changed with element of index: "+(j-gap)+" and element is: "+intArray[j -gap]);
					
					intArray[j] = intArray[j -gap];
					
					j -= gap;
					System.out.println("Current value of j: "+j);
				}
				
				intArray[j] = newElement;
				System.out.println(TextColor.ANSI_YELLOW+"Replaced value at position: "+j+" new value become: "+intArray[j]+"\n\n");
				
				for(int a: intArray) {
					System.out.print(a+"\t");
				}
				
				System.out.println("\n\n");
			}
		}
		
		for(int a: intArray) {
			System.out.print(a+"\t");
		}
	}

}
