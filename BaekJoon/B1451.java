package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1451
// 직사각형으로 나누기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                matrix[i][j] = Integer.parseInt(line.substring(j - 1, j));
            }
        }

        long[][] cumulativeSum = new long[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                cumulativeSum[i][j] = cumulativeSum[i - 1][j] + cumulativeSum[i][j - 1]
                        - cumulativeSum[i - 1][j - 1] + matrix[i][j];
            }
        }

        long answer = 0;
        for (int i = 1; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                long s1 = calculateSum(cumulativeSum, 1, 1, i, M);
                long s2 = calculateSum(cumulativeSum, i + 1, 1, j, M);
                long s3 = calculateSum(cumulativeSum, j + 1, 1, N, M);
                answer = Math.max(answer, s1 * s2 * s3);
            }
        }

        for (int i = 1; i < M - 1; i++) {
            for (int j = i + 1; j < M; j++) {
                long s1 = calculateSum(cumulativeSum, 1, 1, N, i);
                long s2 = calculateSum(cumulativeSum, 1, i + 1, N, j);
                long s3 = calculateSum(cumulativeSum, 1, j + 1, N, M);
                answer = Math.max(answer, s1 * s2 * s3);
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                long s1 = calculateSum(cumulativeSum, 1, 1, N, j);
                long s2 = calculateSum(cumulativeSum, 1, j + 1, i, M);
                long s3 = calculateSum(cumulativeSum, i + 1, j + 1, N, M);
                answer = Math.max(answer, s1 * s2 * s3);
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                long s1 = calculateSum(cumulativeSum, 1, 1, i, j);
                long s2 = calculateSum(cumulativeSum, i + 1, 1, N, j);
                long s3 = calculateSum(cumulativeSum, 1, j + 1, N, M);
                answer = Math.max(answer, s1 * s2 * s3);
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                long s1 = calculateSum(cumulativeSum, 1, 1, i, M);
                long s2 = calculateSum(cumulativeSum, i + 1, 1, N, j);
                long s3 = calculateSum(cumulativeSum, i + 1, j + 1, N, M);
                answer = Math.max(answer, s1 * s2 * s3);
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                long s1 = calculateSum(cumulativeSum, 1, 1, i, j);
                long s2 = calculateSum(cumulativeSum, 1, j + 1, i, M);
                long s3 = calculateSum(cumulativeSum, i + 1, 1, N, M);
                answer = Math.max(answer, s1 * s2 * s3);
            }
        }

        System.out.println(answer);
    }

    private static long calculateSum(long[][] cumulativeSum, int px1, int py1, int px2, int py2) {
        return cumulativeSum[px2][py2] - cumulativeSum[px2][py1 - 1] - cumulativeSum[px1 - 1][py2] +
                cumulativeSum[px1 - 1][py1 - 1];
    }
}
/*
Input
1 8
11911103

Output
108
---
Input
3 3
123
456
789

Output
3264
---
Input
3 1
7
9
3

Output
189
*/
