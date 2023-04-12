package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2638
// 치즈
public class Main {
    private static final int OUTSIDE = -1;
    private static final int TO_BE_MELT = -2;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int numOfCheeses = 0;
        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());
                matrix[i][j] = input;
                if (input == 1) {
                    numOfCheeses++;
                }
            }
        }

        findOutSidePosition(N, M, matrix);

        int day = 0;
        while (numOfCheeses > 0) {
            findToBeMeltPosition(N, M, matrix);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (matrix[i][j] == TO_BE_MELT) {
                        matrix[i][j] = OUTSIDE;
                        bfs(N, M, matrix, i, j);
                        numOfCheeses--;
                    }
                }
            }
            day++;
        }

        System.out.println(day);
    }

    private static void findOutSidePosition(int N, int M, int[][] matrix) {
        for (int x : new int[]{0, N - 1}) {
            for (int y : new int[]{0, M - 1}) {
                if (matrix[x][y] != OUTSIDE) {
                    bfs(N, M, matrix, x, y);
                }
            }
        }
    }

    private static void bfs(int N, int M, int[][] matrix, int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));
        while (!queue.isEmpty()) {
            Position polled = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = polled.x + dx[i];
                int ny = polled.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (matrix[nx][ny] != 1 && matrix[nx][ny] != OUTSIDE && matrix[nx][ny] != TO_BE_MELT) {
                    matrix[nx][ny] = OUTSIDE;
                    queue.add(new Position(nx, ny));
                }
            }
        }
    }

    private static void findToBeMeltPosition(int N, int M, int[][] matrix) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1) {
                    int numOfOutside = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                            continue;
                        }

                        if (matrix[nx][ny] == -1) {
                            numOfOutside++;
                        }
                    }
                    if (numOfOutside >= 2) {
                        matrix[i][j] = TO_BE_MELT;
                    }
                }
            }
        }
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
/*
Input
8 9
0 0 0 0 0 0 0 0 0
0 0 0 1 1 0 0 0 0
0 0 0 1 1 0 1 1 0
0 0 1 1 1 1 1 1 0
0 0 1 1 1 1 1 0 0
0 0 1 1 0 1 1 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0

Output
4
*/
