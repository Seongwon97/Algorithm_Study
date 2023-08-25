package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Two Dots
// https://www.acmicpc.net/problem/16929
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] matrix = new char[N][M];
        boolean[][] visitid;

        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visitid = new boolean[N][M];
                if (hasCycle(matrix, visitid, i, j, i, j, 1)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }

    private static boolean hasCycle(char[][] matrix, boolean[][] visited, int sx, int sy, int x, int y, int depth) {
        visited[x][y] = true;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= matrix.length || ny < 0 || ny >= matrix[0].length || matrix[x][y] != matrix[nx][ny]) {
                continue;
            }

            if (visited[nx][ny]) {
                if (depth >= 4 && sx == nx && sy == ny) {
                    return true;
                }
            } else {
                if (hasCycle(matrix, visited, sx, sy, nx, ny, depth + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
/*
Input
3 4
AAAA
ABCA
AAAA

Output
Yes
*/
