package chapter3_greedy;

import java.util.LinkedList;
import java.util.Queue;

public class Ch5_dfs_bfs_ex2 {

    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        int[][] matrix = {{1, 0, 1, 0, 1, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}};

        int answer = solution(n, m, matrix);
        System.out.println(answer);
    }

    private static int solution(int n, int m, int[][] matrix) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node polled = queue.poll();
            int x = polled.x;
            int y = polled.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (ny < 0 || ny >= m || nx < 0 || nx >= n) {
                    continue;
                }

                if (matrix[nx][ny] == 0) {
                    continue;
                }

                if (matrix[nx][ny] == 1) {
                    matrix[nx][ny] = matrix[x][y] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }

        return matrix[n - 1][m - 1];
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
