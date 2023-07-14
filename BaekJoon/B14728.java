package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14728
// 벼락치기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] times = new int[N + 1];
        int[] scores = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][T + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= T; j++) {
                if (times[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - times[i]] + scores[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][T]);
    }
}
/*
Input
3 310
50 40
100 70
200 150

Output
220
*/
