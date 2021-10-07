package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11053 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		int count = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<i; j++) {
				if (arr[j]< arr[i]) {
					dp[i] = dp[i] < dp[j]+1? dp[j] +1: dp[i];
				}
			}
		}

		Arrays.sort(dp);
		System.out.println(dp[n-1]);
	}

}