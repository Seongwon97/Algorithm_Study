package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/15483
// 최소 편집
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for (int i = 1; i <= A.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= B.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        System.out.println(dp[A.length()][B.length()]);
    }
}
/*
Input
abc
ab

Output
1
------
Input
abcd
bcde

Output
2
------
Input
abababababa
aaaaaaaaaaa

Output
abababababa
aaaaaaaaaaa
*/
