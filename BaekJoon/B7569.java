package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토
// https://www.acmicpc.net/problem/7569
public class B7569 {

    private static int M, N, H;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            int[][][] warehouse = new int[M][N][H];

            int numOfRawTomatoes = 0;
            for (int h = 0; h < H; h++) {
                for (int n = 0; n < N; n++) {
                    st = new StringTokenizer(br.readLine());
                    for (int m = 0; m < M; m++) {
                        int input = Integer.parseInt(st.nextToken());
                        if (input == 0) {
                            numOfRawTomatoes++;
                        }
                        warehouse[m][n][h] = input;
                    }
                }
            }

            int day = bfs(warehouse, numOfRawTomatoes);
            System.out.println(day);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int bfs(int[][][] warehouse, int numOfRawTomatoes) {
        Queue<int[]> queue = new LinkedList<>();
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (warehouse[m][n][h] == 1) {
                        queue.add(new int[]{m, n, h, 0});
                    }
                }
            }
        }

        int[] dm = {-1, 1, 0, 0, 0, 0};
        int[] dn = {0, 0, -1, 1, 0, 0};
        int[] dh = {0, 0, 0, 0, -1, 1};
        int day = 0;
        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int m = polled[0];
            int n = polled[1];
            int h = polled[2];
            day = polled[3];

            for (int i = 0; i < 6; i++) {
                int nm = m + dm[i];
                int nn = n + dn[i];
                int nh = h + dh[i];
                if (nm < 0 || M <= nm || nn < 0 || N <= nn || nh < 0 || H <= nh) {
                    continue;
                }
                if (warehouse[nm][nn][nh] == 0) {
                    warehouse[nm][nn][nh] = 1;
                    queue.offer(new int[]{nm, nn, nh, day + 1});

                    numOfRawTomatoes--;
                }
            }
        }

        if (numOfRawTomatoes == 0) {
            return day;
        }
        return -1;
    }
}

/*
Input
5 3 1
0 -1 0 0 0
-1 -1 0 1 1
0 0 0 1 1

Output
-1
---
Input
5 3 2
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 1 0 0
0 0 0 0 0

Output
4
---
Input
4 3 2
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
-1 -1 -1 -1
1 1 1 -1

Output
0
*/
