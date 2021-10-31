package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B1149 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] info = new int[N][3];
		int[][] dp = new int[N][3];
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<3; j++) {
				info[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 첫번쨰 집의 정보 추가
		for (int j=0; j<3; j++) dp[0][j] = info[0][j];
		
		// 두번째 이후의 집 dp 계산
		for (int i=1; i<N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + info[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + info[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + info[i][2];
		}
		
		int min = Integer.MAX_VALUE;
		for (int i=0; i<3; i++) {
			if(dp[N-1][i] < min) min = dp[N-1][i];
		}
		
		System.out.println(min);
	}

}
