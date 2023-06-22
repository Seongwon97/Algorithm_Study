package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14923
// 미로 탈출
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int hx = Integer.parseInt(st.nextToken());
        int hy = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int ex = Integer.parseInt(st.nextToken());
        int ey = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N + 1][M + 1];
        boolean[][][] visited = new boolean[N + 1][M + 1][2]; // 마지막은 지팡이 사용 유무
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(hx, hy, 0, true));
        visited[hx][hy][0] = true;

        int answer = -1;
        while (!queue.isEmpty()) {
            Node polled = queue.poll();
            if (polled.x == ex && polled.y == ey) {
                answer = polled.numOfMoving;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = polled.x + dx[i];
                int ny = polled.y + dy[i];

                if (nx <= 0 || nx > N || ny <= 0 || ny > M) {
                    continue;
                }

                if (polled.hasMagicChance) { // 지팡이를 아직 사용하지 않은 경우
                    if (matrix[nx][ny] == 0 && !visited[nx][ny][0]) {
                        queue.add(new Node(nx, ny, polled.numOfMoving + 1, polled.hasMagicChance));
                        visited[nx][ny][0] = true;
                    } else if (matrix[nx][ny] == 1 && !visited[nx][ny][1]) {
                        queue.add(new Node(nx, ny, polled.numOfMoving + 1, false));
                        visited[nx][ny][1] = true;
                    }
                } else { // 지팡이를 사용한 경우
                    if (matrix[nx][ny] == 0 && !visited[nx][ny][1]) {
                        queue.add(new Node(nx, ny, polled.numOfMoving + 1, polled.hasMagicChance));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static class Node {
        int x;
        int y;
        int numOfMoving;
        boolean hasMagicChance;

        public Node(int x, int y, int numOfMoving, boolean hasMagicChance) {
            this.x = x;
            this.y = y;
            this.numOfMoving = numOfMoving;
            this.hasMagicChance = hasMagicChance;
        }
    }
}
/*
Input
5 6
1 1
5 6
0 1 1 1 0 0
0 1 1 0 0 0
0 1 0 0 1 0
0 1 0 0 1 0
0 0 0 1 1 0

Output
11
*/
