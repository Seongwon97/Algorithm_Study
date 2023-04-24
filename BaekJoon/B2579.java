package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2579
// 계단 오르기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] stair = new int[301];
        for (int i = 0; i < N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[301];

        dp[0] = stair[0];
        dp[1] = Math.max(stair[0] + stair[1], stair[1]);
        dp[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);

        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 2] + stair[i], stair[i - 1] + stair[i] + dp[i - 3]);
        }

        System.out.println(dp[N - 1]);
    }
}
/*
Input
6
10
20
15
25
10
20

Output
75
*/

