package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 촌수계산
// https://www.acmicpc.net/problem/2644
public class B2644 {

    static int answer = -1;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            boolean[][] matrix = new boolean[n + 1][n + 1];

            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int people1 = Integer.parseInt(st.nextToken());
                int people2 = Integer.parseInt(st.nextToken());
                matrix[people1][people2] = true;
                matrix[people2][people1] = true;
            }

            boolean[] visited = new boolean[n + 1];
             dfs(0, matrix, visited, start, target);

            System.out.println(answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void dfs(int depth, boolean[][] matrix, boolean[] visited, int start, int target) {
        if (start == target) {
            answer = depth;
        }

        visited[start] = true;
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[start][i] && !visited[i]) {
                dfs(depth + 1, matrix, visited, i, target);
            }
        }
    }
}

/*
Input
9
7 3
7
1 2
1 3
2 7
2 8
2 9
4 5
4 6

Output
3
---
Input
9
8 6
7
1 2
1 3
2 7
2 8
2 9
4 5
4 6

Output
-1
*/
