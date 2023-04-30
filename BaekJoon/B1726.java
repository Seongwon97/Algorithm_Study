package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1726
// 로봇
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[M][N];
        boolean[][][] isVisited = new boolean[5][M][N]; // 첫번째는 방향 체크

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;
        int direction = Integer.parseInt(st.nextToken());
        Node start = new Node(x, y, direction, 0);

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken()) - 1;
        y = Integer.parseInt(st.nextToken()) - 1;
        direction = Integer.parseInt(st.nextToken());
        Node end = new Node(x, y, direction, 0);

        int answer = -1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start.direction][start.x][start.y] = true;
        while (!queue.isEmpty()) {
            Node polled = queue.poll();
            if (polled.x == end.x && polled.y == end.y && polled.direction == end.direction) {
                answer = polled.numOfMoved;
                break;
            }

            // 방향 돌려서 추가
            int[] nextDirections = nextDirections(polled.direction);
            for (int i = 0; i < 2; i++) {
                if (!isVisited[nextDirections[i]][polled.x][polled.y]) {
                    queue.add(new Node(polled.x, polled.y, nextDirections[i], polled.numOfMoved + 1));
                    isVisited[nextDirections[i]][polled.x][polled.y] = true;
                }
            }

            // 직진 1~3
            for (int i = 1; i <= 3; i++) {
                int nx = polled.x;
                int ny = polled.y;
                if (polled.direction == 1) {
                    ny += i;
                } else if (polled.direction == 2) {
                    ny -= i;
                } else if (polled.direction == 3) {
                    nx += i;
                } else {
                    nx -= i;
                }

                if (nx < 0 || nx >= M || ny < 0 || ny >= N || isVisited[polled.direction][nx][ny]) {
                    continue;
                }

                // 직진 중간에 벽이 있으면 이후 직진은 불가
                if (matrix[nx][ny] == 1) {
                    break;
                }

                queue.add(new Node(nx, ny, polled.direction, polled.numOfMoved + 1));
                isVisited[polled.direction][nx][ny] = true;
            }
        }

        System.out.println(answer);
    }

    private static int[] nextDirections(int direction) {
        // 방향 1: 동쪽, 2: 서쪽, 3: 남쪽, 4: 북쪽
        if (direction == 1 || direction == 2) {
            return new int[]{3, 4};
        } else {
            return new int[]{1, 2};
        }
    }

    static class Node {
        int x;
        int y;
        int direction;
        int numOfMoved;

        public Node(int x, int y, int direction, int numOfMoved) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.numOfMoved = numOfMoved;
        }
    }
}
/*
Input
5 6
0 0 0 0 0 0
0 1 1 0 1 0
0 1 0 0 0 0
0 0 1 1 1 0
1 0 0 0 0 0
4 2 3
2 4 1

Output
9
*/
