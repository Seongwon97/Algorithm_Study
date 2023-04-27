package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2169
// 로봇 조종하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N + 1][M + 1];
        int[][] temp = new int[2][M + 2];

        dp[1][1] = matrix[1][1];
        for (int i = 2; i <= M; i++) {
            dp[1][i] = dp[1][i - 1] + matrix[1][i];
        }

        for (int i = 2; i <= N; i++) {
            // 왼쪽에서 오른쪽으로 이동했을 때
            temp[0][0] = dp[i - 1][1];
            for (int j = 1; j <= M; j++) {
                temp[0][j] = Math.max(temp[0][j - 1], dp[i - 1][j]) + matrix[i][j];
            }

            // 오른쪽에서 왼쪽으로 이동했을 때
            temp[1][M + 1] = dp[i - 1][M];
            for (int j = M; j >= 1; j--) {
                temp[1][j] = Math.max(temp[1][j + 1], dp[i - 1][j]) + matrix[i][j];
            }

            for (int j = 1; j <= M; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }

        System.out.println(dp[N][M]);
    }
}
/*
Input
5 5
10 25 7 8 13
68 24 -78 63 32
12 -69 100 -29 -25
-16 -22 -57 -33 99
7 -76 -11 77 15

Output
319
*/

