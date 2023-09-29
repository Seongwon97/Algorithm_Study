package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 동전
// https://www.acmicpc.net/problem/9084
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] coins = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				coins[j] = Integer.parseInt(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine());

			int[] dp = new int[M + 1];
			dp[0] = 1;

			for (int coin : coins) {
				for (int j = coin; j <= M; j++) {
					dp[j] += dp[j - coin];
				}
			}
			result.append(dp[M]).append("\n");
		}

		System.out.println(result);
	}
}
/*
Input
3
2
1 2
1000
3
1 5 10
100
2
5 7
22

Output
501
121
1
*/
