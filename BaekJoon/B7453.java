package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7453
// 합이 0인 네 정수
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[4][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        int[] AB = new int[N * N];
        int[] CD = new int[N * N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[idx] = arr[0][i] + arr[1][j];
                CD[idx] = arr[2][i] + arr[3][j];
                idx++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        long answer = 0;
        int start = 0;
        int end = N * N - 1;
        while (start < N * N && end >= 0) {
            int sum = AB[start] + CD[end];

            if (sum == 0) {
                long leftCount = 1;
                long rightCount = 1;
                while (start + 1 < N * N && AB[start] == AB[start + 1]) {
                    leftCount++;
                    start++;
                }

                while (end > 0 && CD[end] == CD[end - 1]) {
                    rightCount++;
                    end--;
                }
                answer += leftCount * rightCount;
                start++;
            } else if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(answer);
    }
}
/*
Input
6
-45 22 42 -16
-41 -27 56 30
-36 53 -37 77
-36 30 -75 -46
26 -38 -10 62
-32 -54 -6 45

Output
5
*/
