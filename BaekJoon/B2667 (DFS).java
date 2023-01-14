package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 단지번호붙이기
// https://www.acmicpc.net/problem/2667
public class B2667_DFS {

    private static int groupCount = 0;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = line.charAt(j) - '0';
                }
            }

            List<Integer> groups = new ArrayList<>();
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && matrix[i][j] == 1) {
                        groupCount = 0;
                        dfs(matrix, visited, i, j);
                        groups.add(groupCount);
                    }
                }
            }

            Collections.sort(groups);
            StringBuilder sb = new StringBuilder();
            sb.append(groups.size()).append("\n");
            for (int group : groups) {
                sb.append(group).append("\n");
            }

            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void dfs(int[][] matrix, boolean[][] visited, int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        visited[x][y] = true;
        groupCount++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 > nx || nx >= matrix.length || 0 > ny || ny >= matrix.length) {
                continue;
            }

            if (matrix[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(matrix, visited, nx, ny);
            }
        }
    }
}

/*
Input
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

Output
3
7
8
9
*/
