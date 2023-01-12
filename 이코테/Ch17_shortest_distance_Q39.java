package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 화성 탐사
public class Ch17_shortest_distance_Q39 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            for (int t = 0; t < T; t++) {
                int N = Integer.parseInt(br.readLine());

                int[][] graph = new int[N][N];
                for (int i = 0; i < N; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < N; j++) {
                        graph[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                int[][] result = dijkstra(graph, N);
                System.out.println(result[N - 1][N - 1]);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] dijkstra(int[][] graph, int N) {
        int[][] minWeight = new int[N][N];
        for (int i = 0; i < minWeight.length; i++) {
            Arrays.fill(minWeight[i], Integer.MAX_VALUE);
        }
        minWeight[0][0] = graph[0][0];

        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(0, 0, minWeight[0][0]));

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (minWeight[node.x][node.y] < node.weight) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    int weight = node.weight + graph[nx][ny];

                    if (weight < minWeight[nx][ny]) {
                        minWeight[nx][ny] = weight;
                        queue.offer(new Node(nx, ny, weight));
                    }
                }
            }
        }

        return minWeight;
    }

    private static class Node implements Comparable<Node> {
        int x;
        int y;
        int weight;

        public Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}

/*
Input
3
3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4

Output
20
19
36
*/
