package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class B11057 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N][10];
		for (int i=0; i<10; i++) {
			dp[0][i] = 1;
		}
		
		for (int i=1; i<N; i++) {
			for (int j=0; j<10; j++) {
				int sum = 0;
				for (int k=0; k<=j; k++) {
					sum += dp[i-1][k];
				}
				dp[i][j] = sum % 10007;
			}
		}
		
		int result = 0;
		for (int i=0; i<10; i++) {
			result += dp[N-1][i];
		}
		
		System.out.println(result % 10007);
		
	}

}
