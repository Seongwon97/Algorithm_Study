package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17182
// 우주 탐사선
public class Main {
    private static int minTime = Integer.MAX_VALUE;
    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드 워셜로 구간별 이동 최단거리 구하기
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        boolean[] visited = new boolean[N];
        visited[K] = true;
        dfs(K, 0, 1, dp, visited);

        System.out.println(minTime);
    }

    // 플로이드워셜로 구한 최단거리를 더하는 방식으로 진행하여도 dfs자체가 N!로 진행되며 자체적으로 최적의 경로를 찾게 된다.
    private static void dfs(int currentPosition, int time, int depth, int[][] dp, boolean[] visited) {
        if (depth == N) {
            minTime = Math.min(minTime, time);
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            dfs(i, time + dp[currentPosition][i], depth + 1, dp, visited);
            visited[i] = false;
        }
    }
}
/*
Input
4 4
3 0 1 4

Output
5
*/
