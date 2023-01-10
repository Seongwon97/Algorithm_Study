package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 병사 배치하기
// https://www.acmicpc.net/problem/18353
public class Ch16_dp_Q34 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int[] soldiers = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = N - 1; i >= 0; i--) {
                soldiers[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[N];
            Arrays.fill(dp, 1);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < i; j++) {
                    if (soldiers[j] < soldiers[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int max = 0;
            for (int d : dp) {
                if (d > max) {
                    max = d;
                }
            }
            System.out.println(N - max);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
Input
7
15 11 4 8 5 2 4

Output
2
*/
