package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// LCS
// https://www.acmicpc.net/problem/9251
public class B9251 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s1 = br.readLine();
            String s2 = br.readLine();

            int s1Length = s1.length();
            int s2Length = s2.length();

            int[][] dp = new int[s1Length + 1][s2Length + 1];
            for (int i = 1; i < s1Length + 1; i++) {
                for (int j = 1; j < s2Length + 1; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            System.out.println(dp[s1Length][s2Length]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
Input
ACAYKP
CAPCAK

Output
4
*/
