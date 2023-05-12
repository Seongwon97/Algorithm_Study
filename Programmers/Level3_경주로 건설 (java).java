import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int N = board.length;
        int answer = Integer.MAX_VALUE;

        boolean[][][] visited = new boolean[N][N][4];

        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0, -1, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == N - 1 && node.y == N - 1) {
                answer = Math.min(answer, node.cost);
            }

            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};
            for (int dir = 0; dir < 4; dir++) {
                int nx = node.x + dx[dir];
                int ny = node.y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] == 1) {
                    continue;
                }

                int newCost = node.cost;
                if (node.dir == -1 || node.dir == dir) {
                    newCost += 100;
                } else {
                    newCost += 600;
                }

                if (!visited[nx][ny][dir] || board[nx][ny] >= newCost) {
                    queue.add(new Node(nx, ny, dir, newCost));
                    visited[nx][ny][dir] = true;
                    board[nx][ny] = newCost;
                }
            }
        }
        return answer;
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int dir;
        int cost;

        public Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
