package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7579
// 앱
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memories = new int[N];
        int[] costs = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memories[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;

        int[][] dp = new int[N][10_001]; // 만들 수 있는 메모리의 크기
        for (int i = 0; i < N; i++) { // 종료한 앱의 수
            int memory = memories[i];
            int cost = costs[i];

            for (int c = 0; c < 10_001; c++) { // 비용
                if (i == 0) {
                    if (c >= cost) {
                        dp[i][c] = memory;
                    }
                } else {
                    if (c >= cost) {
                        dp[i][c] = Math.max(dp[i - 1][c - cost] + memory, dp[i - 1][c]);
                    } else {
                        dp[i][c] = dp[i - 1][c];
                    }
                }

                if (dp[i][c] >= M) {
                    answer = Math.min(answer, c);
                }
            }
        }
        System.out.println(answer);
    }
}
/*
Input
5 60
30 10 20 35 40
3 0 3 5 4

Output
6
*/
