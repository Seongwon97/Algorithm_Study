package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B2920 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[8];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i< arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(solution(arr));
	}
	
	public static String solution(int[] arr) {
		//String[] str = input.split(" ");

		boolean as = false;
		boolean des = false;
		
		for (int i=0; i< arr.length-1; i++) {
			if (i == 0) {
				if (arr[i] < arr[i+1]) as = true;
				else if (arr[i+1] < arr[i]) des = true;
			}
			else {
				if (!des && (arr[i] < arr[i+1])) continue;
				else if (!as && (arr[i+1] < arr[i])) continue;
				else return "mixed";
			}
	
		}
		if (as) return "ascending";
		else return "descending";
	}

}
