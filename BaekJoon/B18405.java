package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 경쟁적 전염 (BFS)
// https://www.acmicpc.net/problem/18405
public class B18405 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            List<Virus> viruses = new ArrayList<>();
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    if (matrix[i][j] != 0) {
                        viruses.add(new Virus(matrix[i][j], 0, i, j));
                    }
                }
            }

            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            Collections.sort(viruses);
            Queue<Virus> queue = new LinkedList<>(viruses);
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};

            while (!queue.isEmpty()) {
                Virus virus = queue.poll();
                if (virus.time == S) {
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = virus.x + dx[i];
                    int ny = virus.y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (matrix[nx][ny] == 0) {
                            matrix[nx][ny] = virus.priority;
                            queue.offer(new Virus(virus.priority, virus.time + 1, nx, ny));
                        }
                    }
                }
            }

            System.out.println(matrix[X - 1][Y - 1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Virus implements Comparable<Virus> {
        int priority;
        int time;
        int x;
        int y;

        public Virus(int priority, int time, int x, int y) {
            this.priority = priority;
            this.time = time;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Virus o) {
            return this.priority - o.priority;
        }
    }
}

/*
Input
3 3
1 0 2
0 0 0
3 0 0
2 3 2

Output
3
---
Input
3 3
1 0 2
0 0 0
3 0 0
1 2 2

Output
0
 */
