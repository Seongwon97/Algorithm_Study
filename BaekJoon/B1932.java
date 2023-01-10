package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정수 삼각형
// https://www.acmicpc.net/problem/1932
public class B1932 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[][] triangle = new int[n][n];
            for (int i = 0; i < triangle.length; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < i + 1; j++) {
                    triangle[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[n][n];
            dp[0][0] = triangle[0][0];
            for (int i = 1; i < triangle.length; i++) {
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0) {
                        dp[i][j] = triangle[i][j] + dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(triangle[i][j] + dp[i - 1][j - 1], triangle[i][j] + dp[i - 1][j]);
                    }
                }
            }

            int answer = 0;
            for (int i = 0; i < n; i++) {
                if (dp[n - 1][i] > answer) {
                    answer = dp[n - 1][i];
                }
            }

            System.out.println(answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
Input
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5

Output
30
 */
