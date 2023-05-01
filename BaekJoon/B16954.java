package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/16954
// 움직이는 미로 탈출
public class Main {
    static boolean answer = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][][] matrix = new char[9][8][8]; // 첫번째는 시간별 변동된 메트릭스
        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            matrix[0][i] = line.toCharArray();
        }

        for (int i = 1; i <= 8; i++) {
            for (int j = i; j < 8; j++) {
                matrix[i][j] = Arrays.copyOf(matrix[i - 1][j - 1], 8);
            }

            for (int j = 0; j < i; j++) {
                Arrays.fill(matrix[i][j], '.');
            }
        }

        dfs(matrix, 0, 7, 0);

        if (answer) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void dfs(char[][][] matrix, int time, int x, int y) {
        // 이미 도착 가능 케이스를 찾은 경우 탐색 중지
        if (answer) {
            return;
        }
        // 8초가 지난 이후에 살아남아있으면 목적지에 도착 가능
        if (time >= 9) {
            answer = true;
            return;
        }
        // 시간이 지났는데 현재 위치에 벽이 내려온 경우 탐색 중지
        if (matrix[time][x][y] == '#') {
            return;
        }

        // 이동 x, 상하좌우, 대각선 이동
        int[] dx = {0, -1, 0, 1, 0, -1, 1, -1, 1};
        int[] dy = {0, 0, -1, 0, 1, 1, 1, -1, -1};
        for (int i = 0; i < 9; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8 || matrix[time][nx][ny] == '#') {
                continue;
            }
            dfs(matrix, time + 1, nx, ny);
        }
    }
}
/*
Input
........
........
........
........
........
........
........
........

Output
1
---
Input
........
........
........
........
........
........
##......
........

Output
0
---
Input
........
........
........
........
........
.#......
#.......
.#......

Output
0
---
Input
........
........
........
........
........
.#######
#.......
........

Output
1
*/
