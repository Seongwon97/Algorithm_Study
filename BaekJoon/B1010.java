package baekjoon;

import java.util.*;
import java.io.*;

public class B1010 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			bw.write(combination(N, M)+"\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}
	static int combination(int N, int M) {
		int[][] dp = new int[N+1][M+1];
		for(int i=2;i<=N;i++)
			dp[i][1]=0;
		
		for(int i=1;i<=M;i++)
			dp[1][i]=i;
		
		for(int i=2;i<=N;i++) {
			for(int j=2;j<=M;j++) {
				dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
			}
		}
		return dp[N][M];
	}

}
