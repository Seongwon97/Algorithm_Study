package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10422
// 괄호
// 풀이 - 카탈란 수 (https://suhak.tistory.com/77)
public class Main {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[5001];
        dp[0] = 1;
        dp[2] = 1;
        for (int i = 4; i <= 5001; i += 2) {
            for (int j = 0; j < i; j += 2) {
                dp[i] += dp[i - j - 2] * dp[j];
                dp[i] %= MOD;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int L = Integer.parseInt(br.readLine());
            if (L % 2 == 1) {
                sb.append(0);
            } else {
                sb.append(dp[L]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
/*
Input
3
1
2
4

Output
0
1
2
*/
