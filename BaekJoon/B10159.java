package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10159
// 저울
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            matrix[start][end] = 1;
            matrix[end][start] = -1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (matrix[i][k] != 0 && matrix[i][k] == matrix[k][j]) {
                        matrix[i][j] = matrix[i][k];
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (i != j && matrix[i][j] == 0) {
                    count++;
                }
            }
            result.append(count)
                    .append("\n");
        }

        System.out.print(result);
    }
}
/*
Input
6
5
1 2
2 3
3 4
5 4
6 5

Output
2
2
2
0
3
3
---
Input
9
11
2 1
3 1
2 8
2 9
7 8
4 5
6 7
6 3
1 7
6 2
1 9

Output
2
3
3
7
7
2
3
3
4
*/
