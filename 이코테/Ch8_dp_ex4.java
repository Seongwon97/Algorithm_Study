package chapter3_greedy;

import java.util.Arrays;

// 바닥 공사
public class Ch8_dp_ex4 {

    public static void main(String[] args) {
        int m = 15;
        int[] coins = {2, 3};
        System.out.println(solution(m, coins));
    }

    private static int solution(int m, int[] coins) {
        int[] dp = new int[m + 1];
        Arrays.fill(dp, 10_001);
        dp[0] = 0;
        Arrays.sort(coins);

        for (int coin : coins) {
            for (int i = coin; i < m + 1; i++) {
                if (dp[i] - coin != 10_001) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        if (dp[m] == 10_001) {
            return -1;
        }
        else {
            return dp[m];
        }
    }
}
