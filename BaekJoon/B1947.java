package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1947
// 선물 전달
public class Main {
    private static final int DIVISOR = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[Math.max(3, N + 1)];
        dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2])) % DIVISOR;
        }

        System.out.println(dp[N]);
    }
}
/*
Input
2

Output
1
------
Input
3

Output
2
-------
Input
4

Output
9
-------
Input
5

Output
44
*/
