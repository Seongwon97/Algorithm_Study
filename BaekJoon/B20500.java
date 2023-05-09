package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/20500
// Ezreal 여눈부터 가네 ㅈㅈ
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 3의 배수는 각 자리수의 합이 3의 배수여야 함
        // 5의 배수는 끝자리 수가 0 또는 5여야함 -> 문제는 1,5로만 만들 수 있어 끝자리가 5로 고정

        // 자리수의 합을 3으로 나눴을 경우의 수 카운트
        int[][] dp = new int[3][1516];
        dp[0][1] = 0;
        dp[0][2] = 1;
        dp[1][2] = 1;
        dp[2][2] = 0;
        for (int i = 3; i < N + 1; i++) {
            dp[0][i] = (dp[2][i - 1] + dp[1][i - 1]) % 1_000_000_007;
            dp[1][i] = (dp[0][i - 1] + dp[2][i - 1]) % 1_000_000_007;
            dp[2][i] = (dp[1][i - 1] + dp[0][i - 1]) % 1_000_000_007;
        }
        System.out.println(dp[0][N]);
    }
}
/*
Input
1

Output
0
---
Input
3

Output
1
---
Input
1515

Output
939178250
*/
