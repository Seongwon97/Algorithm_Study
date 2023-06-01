package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10942
// 팰린드롬?
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[][] questions = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            questions[i][0] = Integer.parseInt(st.nextToken());
            questions[i][1] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = isPalindrome(numbers, N);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (dp[questions[i][0]][questions[i][1]]) {
                result.append(1).append("\n");
            } else {
                result.append(0).append("\n");
            }
        }

        System.out.print(result);
    }

    private static boolean[][] isPalindrome(int[] numbers, int N) {
        boolean[][] dp = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;
        }

        for (int i = 1; i < N; i++) {
            if (numbers[i] == numbers[i + 1]) {
                dp[i][i + 1] = true;
            }
        }

        for (int i = 2; i < N; i++) {
            for (int j = 1; j <= N - i; j++) {
                if (numbers[j] == numbers[j + i] && dp[j + 1][j + i - 1]) {
                    dp[j][j + i] = true;
                }
            }
        }
        return dp;
    }
}
/*
Input
7
1 2 1 3 1 2 1
4
1 3
2 5
3 3
5 7

Output
1
0
1
1
---
Input
8
1 1 2 4 2 1 4 4
1
1 6

Output
0
---
Input
6
1 2 3 2 1 1
1
1 6

Output
0
---
Input
3
1 1 1
1
1 2

Output
1
*/
