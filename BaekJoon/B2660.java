package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2660
// 회장뽑기
public class Main {
    private static final int INF = 1000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    matrix[i][j] = INF;
                }
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) {
                break;
            }

            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                        int distance = matrix[i][k] + matrix[k][j];
                        matrix[i][j] = distance;
                        matrix[j][i] = distance;
                    }
                }
            }
        }

        List<Integer> candidates = new ArrayList<>();
        int minScore = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int max = 0;
            for (int j = 1; j <= N; j++) {
                max = Math.max(max, matrix[i][j]);
            }

            if (max == minScore) {
                candidates.add(i);
            } else if (max < minScore) {
                minScore = max;
                candidates.clear();
                candidates.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(minScore)
                .append(" ")
                .append(candidates.size())
                .append("\n");

        for (Integer candidate : candidates) {
            sb.append(candidate)
                    .append(" ");
        }

        System.out.println(sb);
    }
}
/*
Input
5
1 2
2 3
3 4
4 5
2 4
5 3
-1 -1

Output
2 3
2 3 4
*/
