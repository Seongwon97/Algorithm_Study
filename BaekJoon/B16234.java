package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 인구 이동 (BFS)
// https://www.acmicpc.net/problem/16234
public class B16234 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int day = -1;
            while (true) {
                day++;
                boolean[][] visited = new boolean[matrix.length][matrix.length];
                int count = 0;
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix.length; j++) {
                        if (!visited[i][j]) {
                            count++;
                            List<Node> visitedNode = new ArrayList<>();
                            visitedNode.add(new Node(i, j));
                            dfs(L, R, matrix, visitedNode, visited, i, j);
                            relocatePopulation(matrix, visitedNode);
                        }
                    }
                }

                if (count == (matrix.length * matrix.length)) {
                    break;
                }
            }

            System.out.println(day);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void relocatePopulation(int[][] matrix, List<Node> visitedNode) {
        int sum = 0;
        for (Node node : visitedNode) {
            sum += matrix[node.x][node.y];
        }

        int relocatePopulation = sum / visitedNode.size();

        for (Node node : visitedNode) {
            matrix[node.x][node.y] = relocatePopulation;
        }
    }

    private static void dfs(int l, int r, int[][] matrix, List<Node> visitedNodes, boolean[][] visited, int x, int y) {
        int length = matrix.length;
        visited[x][y] = true;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < length && ny >= 0 && ny < length && !visited[nx][ny]) {
                int populationDifference = Math.abs(matrix[x][y] - matrix[nx][ny]);
                if (l <= populationDifference && populationDifference <= r) {
                    visitedNodes.add(new Node(nx, ny));
                    dfs(l, r, matrix, visitedNodes, visited, nx, ny);
                }
            }
        }
    }

    private static class Node {
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
2 20 50
50 30
20 40

Output
1
---
Input
2 40 50
50 30
20 40

Output
0
---
Input
2 20 50
50 30
30 40

Output
1
 */
