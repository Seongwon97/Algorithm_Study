package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1937
// 욕심쟁이 판다
public class Main {
    private static int N;
    private static int[][] matrix;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], 1);
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dfs(i, j);
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }

            if (matrix[nx][ny] <= matrix[x][y]) {
                continue;
            }

            if (dp[nx][ny] == 1) {
                dfs(nx, ny);
            }
            dp[x][y] = Math.max(dp[x][y], dp[nx][ny] + 1);
        }
    }
}
/*
Input
4
14 9 12 10
1 11 5 4
7 15 2 13
6 3 16 8

Output
4
*/
