package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 편집 거리
public class Ch16_dp_Q36 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String origin = br.readLine();
            String target = br.readLine();

            int originLength = origin.length();
            int targetLength = target.length();
            int[][] dp = new int[originLength + 1][targetLength + 1];

            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = i;
            }

            for (int i = 0; i < dp[0].length; i++) {
                dp[0][i] = i;
            }

            for (int i = 1; i < originLength + 1; i++) {
                for (int j = 1; j < targetLength + 1; j++) {
                    if (origin.charAt(i - 1) == target.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        int minValue = Math.min(dp[i][j - 1], dp[i - 1][j]);
                        minValue = Math.min(minValue, dp[i - 1][j - 1]);
                        dp[i][j] = 1 + minValue;
                    }
                }
            }

            System.out.println(dp[originLength][targetLength]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
Input
cat
cut

Output
1
---
Input
sunday
saturday

Output
3
*/
