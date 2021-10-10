package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class B9251 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		char[] strArr1 = br.readLine().toCharArray();
		char[] strArr2 = br.readLine().toCharArray();
		
		int[][] dp = new int[strArr2.length+1][strArr1.length];
		
		for (int i=0; i< strArr1.length; i++) {
			dp[0][i] = 0;
		}
		

		for (int i=0; i<strArr2.length ; i++) {
			int max = 0;
			for (int j=0; j<strArr1.length; j++) {
				dp[i+1][j] = dp[i][j];
				if (strArr2[i] == strArr1[j]) {
					for (int k=0; k< j; k++) {
						if (dp[i][k] > max) max = dp[i][k];
					}
					
					dp[i+1][j] = dp[i+1][j] < max+1 ? max+1: dp[i+1][j];
				}
			}
		}
		
		
		//System.out.println(1);
		
		int max = 0;
		for (int j=0; j<strArr1.length; j++) {
			if (dp[strArr2.length][j] > max) max = dp[strArr2.length][j];
		}
		
		System.out.println(max);
	}

}
