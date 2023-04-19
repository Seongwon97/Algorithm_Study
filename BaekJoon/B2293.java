package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2293
// 동전 1
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins);

        int[] dp = new int[K + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= K; i++) {
                dp[i] += dp[i - coin];
            }
        }
        System.out.println(dp[K]);
    }
}
/*
Input
3 10
1
2
5

Output
10
*/

