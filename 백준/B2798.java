package baekjoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
        int m = sc.nextInt();

		
		int[] card = new int[n];
		
		for (int i=0; i< card.length; i++) {
			card[i] = sc.nextInt();
		}
		
		int result = 0;
		int sum = 0;
		for (int i= 0; i< card.length-2; i++) {
			for (int j= i+1; j< card.length-1; j++) {
				for (int k= j+1; k< card.length; k++) {
					sum = card[i] + card[j] + card[k];
					if (sum <= m) {
						result = Math.max(sum, result);
					}
				}
			}
		}
		
		
		System.out.println(result);
	}
}
