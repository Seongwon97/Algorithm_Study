package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2240
// 자두나무
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] info = new int[T + 1];
        int[][][] dp = new int[3][T + 1][W + 2]; // 위치, 시간, 이동횟수
        for (int i = 1; i <= T; i++) {
            info[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= T; i++) {
            for (int j = 1; j <= W + 1; j++) {
                if (info[i] == 1) {
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]) + 1;
                    dp[2][i][j] = Math.max(dp[2][i - 1][j], dp[1][i - 1][j - 1]);
                } else {
                    if (i == 1 && j == 1) {
                        continue;
                    }
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]);
                    dp[2][i][j] = Math.max(dp[2][i - 1][j], dp[1][i - 1][j - 1]) + 1;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= W + 1; i++) {
            answer = Math.max(answer, Math.max(dp[1][T][i], dp[2][T][i]));
        }

        System.out.println(answer);
    }
}
/*
Input
5 2 2
1
2
3
4
5
1 3 6
2 2 5
1 5 2
2 3 5

Output
240
48
---
Input
5 2 2
1
2
3
4
5
1 3 0
2 2 5
1 3 6
2 2 5

Output
0
240
*/
