package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B2750 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		
		for (int i=0; i< num; i++) {
			arr[i] = sc.nextInt();
		}
		
		// Sort
		//Arrays.sort(arr);
		
		// Bubble sort
		int temp = 0;
		for (int i=0; i< arr.length; i++) {
			for(int j=0; j< arr.length-i-1;j++) {
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		
		for (int i=0; i< num; i++) {
			System.out.println(arr[i]);
		}
	}

}
