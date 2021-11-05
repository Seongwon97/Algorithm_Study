package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B11052 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i=1; i<=N; i++) dp[i] = Integer.parseInt(st.nextToken());
		
		for (int i=2; i<=N; i++) {
			int max = dp[i];
			for (int j=0; j<((i/2)+1) ; j++) {
				if ((dp[j] + dp[i-j]) > max) {
					max = dp[j] + dp[i-j];
				}
			}
			dp[i] = max;
		}
        System.out.println(dp[N]);
	}

}
