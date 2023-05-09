package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1007
// 벡터 매칭
public class Main {
    private static double answer;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            answer = Double.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            int[][] points = new int[N][2];
            int[] sum = new int[2];

            for (int n = 0; n < N; n++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[n][0] = x;
                points[n][1] = y;

                sum[0] += x;
                sum[1] += y;
            }
            recur(points, 0, 0, sum[0], sum[1]);
            System.out.println(answer);
        }

    }

    private static void recur(int[][] points, int count, int previous, int x, int y) {
        if (count == N / 2) {
            answer = Math.min(answer, Math.sqrt((double) x * x + (double) y * y));
            return;
        }
        for (int i = previous; i < N; i++) {
            recur(points, count + 1, i + 1, x - 2 * points[i][0], y - 2 * points[i][1]);
        }
    }
}
/*
Input
2
4
5 5
5 -5
-5 5
-5 -5
2
-100000 -100000
100000 100000

Output
0.000000000000
282842.712474619038
---
Input
1
10
26 -76
65 -83
78 38
92 22
-60 -42
-27 85
42 46
-86 98
92 -47
-41 38

Output
13.341664064126334
*/
