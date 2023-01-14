package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 말이 되고픈 원숭이
// https://www.acmicpc.net/problem/1600
public class B1600 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int[][] matrix = new int[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = bfs(K, W, H, matrix);

            System.out.println(answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int bfs(int K, int W, int H, int[][] matrix) {
        boolean[][][] visited = new boolean[H][W][K + 1];
        Queue<HorsePosition> queue = new LinkedList<>();

        queue.add(new HorsePosition(0, 0, 0, 0));
        visited[0][0][0] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int[] sdx = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] sdy = {2, 1, -1, -2, -2, -1, 1, 2};

        while (!queue.isEmpty()) {
            HorsePosition position = queue.poll();
            if (position.x == H - 1 && position.y == W - 1) {
                return position.numOfMoves;
            }

            for (int i = 0; i < 4; i++) {
                int nx = position.x + dx[i];
                int ny = position.y + dy[i];
                if (isValidPosition(matrix, nx, ny, H, W) && !visited[nx][ny][position.numOfUsedSpecialMoves]) {
                    visited[nx][ny][position.numOfUsedSpecialMoves] = true;
                    queue.offer(new HorsePosition(nx, ny, position.numOfUsedSpecialMoves,
                            position.numOfMoves + 1));
                }
            }

            if (position.numOfUsedSpecialMoves < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = position.x + sdx[i];
                    int ny = position.y + sdy[i];
                    if (isValidPosition(matrix, nx, ny, H, W) && !visited[nx][ny][position.numOfUsedSpecialMoves + 1]) {
                        visited[nx][ny][position.numOfUsedSpecialMoves + 1] = true;
                        queue.offer(new HorsePosition(nx, ny, position.numOfUsedSpecialMoves + 1,
                                position.numOfMoves + 1));
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValidPosition(int[][] matrix, int nx, int ny, int h, int w) {
        return 0 <= nx && nx < h && 0 <= ny && ny < w && matrix[nx][ny] == 0;
    }

    private static class HorsePosition {
        int x;
        int y;
        int numOfUsedSpecialMoves;
        int numOfMoves;

        public HorsePosition(int x, int y, int numOfUsedSpecialMoves, int numOfMoves) {
            this.x = x;
            this.y = y;
            this.numOfUsedSpecialMoves = numOfUsedSpecialMoves;
            this.numOfMoves = numOfMoves;
        }
    }
}

/*
Input
1
4 4
0 0 0 0
1 0 0 0
0 0 1 0
0 1 0 0

Output
4
---
Input
2
5 2
0 0 1 1 0
0 0 1 1 0

Output
-1
*/
