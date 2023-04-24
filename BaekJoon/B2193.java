package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2193
// 이진수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1 || N == 2) {
            // 숫자는 각각 1과 10만 존재
            System.out.println(1);
        } else if (N == 3) {
            // 101, 100
            System.out.println(2);
        } else {
            long[][] dp = new long[2][N + 1];
            dp[0][3] = 1;
            dp[1][3] = 1;
            for (int i = 4; i <= N; i++) {
                dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
                dp[1][i] = dp[0][i - 1];
            }
            System.out.println(dp[0][N] + dp[1][N]);
        }
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

