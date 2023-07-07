class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }

        for (int i = 1; i <= m; i++) {
            if (dp[1][i] == -1) {
                break;
            }
            dp[1][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (dp[i][1] == -1) {
                break;
            }
            dp[i][1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                if (dp[i][j] == -1) { // 현재칸이 웅덩이인경우 Pass
                    continue;
                }

                if (dp[i - 1][j] == -1 && dp[i][j - 1] == -1) { // 위와 왼쪽 칸이 웅덩이인 경우
                    continue;
                } else if (dp[i - 1][j] == -1) { // 위의 칸이 웅덩이인 경우
                    dp[i][j] = dp[i][j - 1];
                } else if (dp[i][j - 1] == -1) { // 위의 칸이 웅덩이인 경우
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1_000_000_007;
                }
            }
        }

        return dp[n][m];
    }
}
