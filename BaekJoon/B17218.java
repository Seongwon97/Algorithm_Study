package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/17218
// 비밀번호 만들기
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int remainLength = dp[A.length()][B.length()];
        int indexOfA = A.length();
        int indexOfB = B.length();
        while (remainLength > 0) {
            if (dp[indexOfA - 1][indexOfB] == remainLength) {
                indexOfA--;
            } else if (dp[indexOfA][indexOfB - 1] == remainLength) {
                indexOfB--;
            } else {
                sb.append(A.charAt(indexOfA - 1));
                remainLength--;
                indexOfA--;
                indexOfB--;
            }
        }

        sb.reverse();
        System.out.println(sb);
    }
}
/*
Input
AUTABBEHNSA
BCUAMEFKAJNA

Output
UAENA
------
Input
SETAPPLE
EATMANY

Output
ETA
*/
