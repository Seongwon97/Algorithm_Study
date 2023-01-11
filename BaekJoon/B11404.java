package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 플로이드
// https://www.acmicpc.net/problem/11404
public class B11404 {

    private static int INF = 100_000_000;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        matrix[i][j] = INF;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int startingPoint = Integer.parseInt(st.nextToken());
                int destination = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                matrix[startingPoint - 1][destination - 1] = Math.min(matrix[startingPoint - 1][destination - 1],
                        weight);
            }

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == INF) {
                        sb.append("0 ");
                    } else {
                        sb.append(matrix[i][j])
                                .append(" ");
                    }
                }
                sb.append("\n");
            }
            System.out.print(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
Input
5
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4

Output
1
---
Input
sunday
saturday

Output
0 2 3 1 4
12 0 15 2 5
8 5 0 1 1
10 7 13 0 3
7 4 10 6 0
*/
