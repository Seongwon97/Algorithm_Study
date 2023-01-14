package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// ACM Craft
// https://www.acmicpc.net/problem/1005
public class B1005 {

    private static int M, N, H;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(st.nextToken()); // 건물의 개수
                int K = Integer.parseInt(st.nextToken()); // 규칙의 수

                int[] buildTime = new int[N + 1];
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < N + 1; j++) {
                    buildTime[j] = Integer.parseInt(st.nextToken());
                }

                int[] indegree = new int[N + 1];
                boolean[][] orderInfo = new boolean[N + 1][N + 1]; // orderInfo[x][y] -> x이후에 y를 지어야 함

                for (int j = 0; j < K; j++) {
                    st = new StringTokenizer(br.readLine());
                    int X = Integer.parseInt(st.nextToken());
                    int Y = Integer.parseInt(st.nextToken());
                    indegree[Y]++;
                    orderInfo[X][Y] = true;
                }

                int W = Integer.parseInt(br.readLine());

                int currentTime = 0;
                Queue<Building> queue = new PriorityQueue<>();
                for (int j = 1; j < N + 1; j++) {
                    if (indegree[j] == 0) {
                        queue.offer(new Building(j, currentTime + buildTime[j]));
                    }
                }

                while (!queue.isEmpty()) {
                    Building building = queue.poll();
                    currentTime = building.endTime;
                    if (building.id == W) {
                        break;
                    }

                    for (int j = 1; j < N + 1; j++) {
                        if (orderInfo[building.id][j]) {
                            indegree[j]--;
                            if (indegree[j] == 0) {
                                queue.offer(new Building(j, currentTime + buildTime[j]));
                            }
                        }
                    }
                }
                System.out.println(currentTime);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static class Building implements Comparable<Building> {
        int id;
        int endTime;

        public Building(int id, int endTime) {
            this.id = id;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Building o) {
            return this.endTime - o.endTime;
        }
    }
}

/*
Input
2
4 4
10 1 100 10
1 2
1 3
2 4
3 4
4
8 8
10 20 1 5 8 7 1 43
1 2
1 3
2 4
2 5
3 6
5 7
6 7
7 8
7

Output
120
39
----------------------------------------
Input
5
3 2
1 2 3
3 2
2 1
1
4 3
5 5 5 5
1 2
1 3
2 3
4
5 10
100000 99999 99997 99994 99990
4 5
3 5
3 4
2 5
2 4
2 3
1 5
1 4
1 3
1 2
4
4 3
1 1 1 1
1 2
3 2
1 4
4
7 8
0 0 0 0 0 0 0
1 2
1 3
2 4
3 4
4 5
4 6
5 7
6 7
7

Output
6
5
399990
2
0
*/
