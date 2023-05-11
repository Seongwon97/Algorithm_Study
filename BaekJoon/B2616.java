package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2616
// 소형기관차
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] cumulativeSum = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cumulativeSum[i] = cumulativeSum[i - 1] + arr[i];
        }

        int numOfPull = Integer.parseInt(br.readLine());

        int[][] dp = new int[4][N + 1];
        for (int i = 1; i < 4; i++) {
            for (int j = i * numOfPull; j <= N; j++) {
                dp[i][j] = Math.max(
                        dp[i][j - 1],
                        dp[i - 1][j - numOfPull] + (cumulativeSum[j] - cumulativeSum[j - numOfPull])
                );
            }
        }

        System.out.println(dp[3][N]);
    }
}
/*
Input
7
35 40 50 10 30 45 60
2

Output
240
*/
