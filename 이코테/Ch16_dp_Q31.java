package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 금광
public class Ch16_dp_Q31 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                st = new StringTokenizer(br.readLine());
                int[][] matrix = new int[n][m];

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        matrix[j][k] = Integer.parseInt(st.nextToken());
                    }
                }

                System.out.println(findMaximumGoldSize(n, m, matrix));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int findMaximumGoldSize(int n, int m, int[][] matrix) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int existGold = matrix[j][i];
                if (isValidPosition(n, m, j + 1, i - 1)) { // 이전이 왼쪽 위
                    dp[j][i] = Math.max(dp[j][i], existGold + dp[j + 1][i - 1]);
                }
                if (isValidPosition(n, m, j, i - 1)) { // 이전이 왼쪽
                    dp[j][i] = Math.max(dp[j][i], existGold + dp[j][i - 1]);
                }
                if (isValidPosition(n, m, j - 1, i - 1)) { // 이전이 왼쪽 아래
                    dp[j][i] = Math.max(dp[j][i], existGold + dp[j - 1][i - 1]);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[i][m - 1]);
        }

        return answer;
    }

    private static boolean isValidPosition(int n, int m, int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}

/*
Input
2
3 4
1 3 3 2 2 1 4 1 0 6 4 7
4 4
1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2

Output
19
16
 */
