package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2591
// 숫자카드
public class Main {
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = input.length();

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < N; i++) {
            if (input.charAt(i) != '0') {
                dp[i + 1] += dp[i];
            }
            if (isCombinable(input, i - 1)) {
                dp[i + 1] += dp[i - 1];
            }
        }

        System.out.println(dp[N]);
    }

    private static boolean isCombinable(String numbers, int startIdx) {
        int n = Integer.parseInt(numbers.substring(startIdx, startIdx + 2));
        return 10 <= n && n <= 34;
    }
}
/*
Input
27123

Output
6
*/
