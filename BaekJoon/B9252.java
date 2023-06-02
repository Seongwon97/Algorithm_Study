package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/9252
// LCS 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

        int[][] dp = new int[first.length() + 1][second.length() + 1];
        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int maxLength = dp[first.length()][second.length()];
        System.out.println(maxLength);
        if (maxLength == 0) {
            return;
        }

        // 마지막 문자 찾기
        char[] lcs = new char[maxLength];
        int lastIndex1 = 0;
        int lastIndex2 = 0;
        boolean isFound = false;
        for (int i = 1; i <= first.length(); i++) {
            if (isFound) {
                break;
            }
            for (int j = 1; j <= second.length(); j++) {
                if (dp[i][j] == maxLength) {
                    lcs[maxLength - 1] = first.charAt(i - 1);
                    lastIndex1 = i - 1;
                    lastIndex2 = j - 1;
                    isFound = true;
                    break;
                }
            }
        }

        int nextIndex = maxLength - 1;
        for (int i = lastIndex1; i > 0; i--) {
            for (int j = lastIndex2; j > 0; j--) {
                if (dp[i][j] == nextIndex && first.charAt(i - 1) == second.charAt(j - 1)) {
                    lcs[--nextIndex] = first.charAt(i - 1);
                    lastIndex2 = j - 1;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : lcs) {
            sb.append(c);
        }

        System.out.println(sb);
    }
}
/*
Input
ACAYKP
CAPCAK

Output
4
ACAK
*/
