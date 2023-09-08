package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// RGB거리 2
// https://www.acmicpc.net/problem/17404
public class Main {
	private static final int INF = 1_000 * 1_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] weight = new int[N + 1][3];
		int[][] dp = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				weight[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = INF;

		for (int start = 0; start < 3; start++) {
			for (int i = 0; i < 3; i++) {
				if (start == i) {
					dp[1][i] = weight[1][i];
				} else {
					dp[1][i] = INF;
				}
			}

			for (int i = 2; i <= N; i++) {
				dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + weight[i][0];
				dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + weight[i][1];
				dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + weight[i][2];
			}

			for (int i = 0; i < 3; i++)
				if (start != i) {
					answer = Math.min(answer, dp[N][i]);
				}
		}

		System.out.println(answer);
	}
}
/*
Input
3
26 40 83
49 60 57
13 89 99

Output
110
*/
