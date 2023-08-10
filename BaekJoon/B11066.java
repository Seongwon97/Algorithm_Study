package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11066
// 파일 합치기
// https://developerbee.tistory.com/97
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] chapters = new int[K];
            int[][] dp = new int[K][K]; // i 번째에서 j번째 까지 합의 최소값
            int[] cumulativeSum = new int[K];

            for (int i = 0; i < K; i++) {
                chapters[i] = Integer.parseInt(st.nextToken());
            }

            cumulativeSum[0] = chapters[0];
            for (int i = 1; i < K; i++) {
                cumulativeSum[i] = cumulativeSum[i - 1] + chapters[i];
            }

            for (int i = 0; i < K - 1; i++) {
                dp[i][i + 1] = chapters[i] + chapters[i + 1];
            }

            for (int i = 2; i < K; i++) {
                for (int j = 0; i + j < K; j++) {
                    for (int k = j; k < i + j; k++) {
                        if (dp[j][i + j] == 0) {
                            dp[j][i + j] = dp[j][k] + dp[k + 1][i + j] + findSectionSum(cumulativeSum, j, i + j);
                        } else {
                            dp[j][i + j] = Math.min(dp[j][i + j],
                                    dp[j][k] + dp[k + 1][i + j] + findSectionSum(cumulativeSum, j, i + j));
                        }
                    }
                }
            }

            System.out.println(dp[0][K - 1]);
        }
    }

    private static int findSectionSum(int[] cumulativeSum, int start, int end) {
        if (start == 0) {
            return cumulativeSum[end];
        }
        return cumulativeSum[end] - cumulativeSum[start - 1];
    }
}
/*
Input
2
4
40 30 30 50
15
1 21 3 4 5 35 5 4 3 5 98 21 14 17 32

Output
300
864
*/
