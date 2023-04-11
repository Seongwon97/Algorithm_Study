import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int depth = triangle.length;
        int[][] dp = new int[depth][depth];
        for (int i = 0; i < depth; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        for (int i = 0; i < depth; i++) {
            dp[depth - 1][i] = triangle[depth - 1][i];
        }

        for (int i = depth - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];
    }
}
