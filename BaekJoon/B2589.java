package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2589
// 보물섬
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        char[][] matrix = new char[h][w];
        for (int i = 0; i < h; i++) {
            matrix[i] = br.readLine().toCharArray();
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int maxDistance = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == 'W') {
                    continue;
                }
                // bfs
                boolean[][] visited = new boolean[h][w];
                Queue<Node> queue = new LinkedList<>();
                queue.add(new Node(i, j, 0));
                visited[i][j] = true;
                while (!queue.isEmpty()) {
                    Node polled = queue.poll();
                    if (maxDistance < polled.weight) {
                        maxDistance = polled.weight;
                    }

                    for (int k = 0; k < 4; k++) {
                        int nx = polled.x + dx[k];
                        int ny = polled.y + dy[k];
                        if (nx < 0 || nx >= h || ny < 0 || ny >= w || visited[nx][ny] || matrix[nx][ny] == 'W') {
                            continue;
                        }
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny, polled.weight + 1));
                    }

                }
            }
        }
        System.out.println(maxDistance);
    }

    static class Node {
        int x;
        int y;
        int weight;

        public Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
}
/*
Input
5 7
WLLWWWL
LLLWLLL
LWLWLWW
LWLWLLL
WLLWLWW

Output
8
---
Input
3 3
LLW
WWW
WWW

Output
1
---
Input
5 5
LLLLL
LWWWL
LWWWL
LWWWL
LLLLL

Output
8
*/

