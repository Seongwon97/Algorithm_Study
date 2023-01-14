package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 탈출
// https://www.acmicpc.net/problem/3055
public class B3055 {

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int R, C;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            char[][] matrix = new char[R][C];

            Queue<int[]> queue = new LinkedList<>();
            Queue<int[]> water = new LinkedList<>();
            for (int i = 0; i < R; i++) {
                String line = br.readLine();
                for (int j = 0; j < C; j++) {
                    char c = line.charAt(j);
                    matrix[i][j] = c;
                    if (c == 'S') {
                        queue.add(new int[]{i, j, 0});
                    } else if (c == '*') {
                        water.add(new int[]{i, j});
                    }
                }
            }

            int answer = finaAnswer(matrix, queue, water);
            if (answer == -1) {
                System.out.println("KAKTUS");
            } else {
                System.out.println(answer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int finaAnswer(char[][] matrix, Queue<int[]> queue, Queue<int[]> water) {
        while (!queue.isEmpty()) {
            // 바다 크기 늘리기
            expandWater(matrix, water);

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] position = queue.poll();
                int x = position[0];
                int y = position[1];
                int depth = position[2];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (0 > nx || nx >= R || 0 > ny || ny >= C) {
                        continue;
                    }

                    if (matrix[nx][ny] == 'D') {
                        return depth + 1;
                    }

                    if (matrix[nx][ny] == '.') {
                        matrix[nx][ny] = 'S';
                        queue.offer(new int[]{nx, ny, depth + 1});
                    }
                }
            }
        }

        return -1;
    }

    private static void expandWater(char[][] matrix, Queue<int[]> water) {
        int size = water.size();
        for (int i = 0; i < size; i++) {
            int[] polled = water.poll();
            int x = polled[0];
            int y = polled[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (0 > nx || nx >= R || 0 > ny || ny >= C) {
                    continue;
                }

                if (matrix[nx][ny] == '.') {
                    matrix[nx][ny] = '*';
                    water.add(new int[]{nx, ny});
                }
            }
        }
    }
}

/*
Input
3 3
D.*
...
.S.

Output
3
-------
Input
3 3
D.*
...
..S

Output
KAKTUS
-------
Input
3 6
D...*.
.X.X..
....S.

Output
6
-------
Input
5 4
.D.*
....
..X.
S.*.
....

Output
4

*/
