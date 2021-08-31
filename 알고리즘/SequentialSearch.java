package algorithm;

import java.util.Arrays;

public class SequentialSearch {
	public static void main(String[] args) {
		int[] arr = new int[10];
		
		for(int i = 0; i < 9; i++) {
			arr[i] = (int)(Math.random()*100);
		}
		arr[9] = 35;
		
		Arrays.sort(arr);
		for (int num: arr) 
			System.out.print(num + "\t");
		
		
		System.out.println();
		System.out.println(sequentialSearch(arr, 35));
		
	}
	
	public static int sequentialSearch(int[] arr, int search) {
		if (arr.length == 1 && arr[0] == search) return 0;
		if (arr.length == 1 && arr[0] != search) return -1;
		if (arr.length == 0) return -1;
		
		for (int i = 0; i< arr.length; i++) {
			if (arr[i] == search) return i;
		}
		return -1;
	}
}
