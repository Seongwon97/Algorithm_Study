package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 단지번호붙이기
// https://www.acmicpc.net/problem/2667
public class B2667 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = line.charAt(j) - 48;
                }
            }

            List<Integer> groups = new ArrayList<>();
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && matrix[i][j] == 1) {
                        groups.add(bfs(matrix, visited, i, j));
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

    private static int bfs(int[][] matrix, boolean[][] visited, int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        int numOfHouses = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        while (!queue.isEmpty()) {
            Node polled = queue.poll();
            if (visited[polled.x][polled.y]) {
                continue;
            }

            visited[polled.x][polled.y] = true;
            numOfHouses++;

            for (int i = 0; i < 4; i++) {
                int nx = polled.x + dx[i];
                int ny = polled.y + dy[i];

                if (0 > nx || nx >= matrix.length || 0 > ny || ny >= matrix.length) {
                    continue;
                }

                if (matrix[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new Node(nx, ny));
                }
            }
        }

        return numOfHouses;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
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
