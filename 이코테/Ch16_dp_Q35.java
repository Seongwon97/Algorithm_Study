package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 못생긴 수
public class Ch16_dp_Q35 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            int[] dp = new int[N];
            dp[0] = 1;

            // 2, 3, 5 배를 위한 인덱스
            int index2 = 0;
            int index3 = 0;
            int index5 = 0;
            // 곱셈값 초기화
            int next2 = 2;
            int next3 = 3;
            int next5 = 5;

            for (int i = 1; i < N; i++) {
                // 가능한 곱셈 결과 중에서 가장 작은 수 선
                dp[i] = Math.min(next2, next3);
                dp[i] = Math.min(dp[i], next5);
                if (dp[i] == next2) {
                    index2 += 1;
                    next2 = dp[index2] * 2;
                }
                if (dp[i] == next3) {
                    index3 += 1;
                    next3 = dp[index3] * 3;
                }
                if (dp[i] == next5) {
                    index5 += 1;
                    next5 = dp[index5] * 5;
                }
            }

            System.out.println(dp[N - 1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
Input
10

Output
12
---
Input
4

Output
4
*/
