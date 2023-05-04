package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2294
// 동전 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 코인 1개로 만들 수 있는 돈에 대한 카운트 증가
        for (int coin : coins) {
            if (coin <= k) {
                dp[coin] = 1;
            }
        }

        for (int i = 1; i <= k; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            for (int coin : coins) {
                if (i + coin <= k) {
                    dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
                }
            }
        }

        if (dp[k] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}
/*
Input
5 2 2
1
2
3
4
5
1 3 6
2 2 5
1 5 2
2 3 5

Output
240
48
---
Input
5 2 2
1
2
3
4
5
1 3 0
2 2 5
1 3 6
2 2 5

Output
0
240
*/
