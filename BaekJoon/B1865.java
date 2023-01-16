package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 웜홀
// https://www.acmicpc.net/problem/1865
public class B1865 {

    private static int INF = 10_000_000;
    private static List<Edge>[] graph;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int TC = Integer.parseInt(br.readLine());
            for (int t = 0; t < TC; t++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(st.nextToken()); // 지점의 수
                int M = Integer.parseInt(st.nextToken()); // 도로의 수
                int W = Integer.parseInt(st.nextToken()); // 웜홀의 수
                graph = new ArrayList[N + 1];
                for (int i = 1; i <= N; i++) {
                    graph[i] = new ArrayList<>();
                }

                for (int m = 0; m < M; m++) {
                    st = new StringTokenizer(br.readLine());
                    int S = Integer.parseInt(st.nextToken()); // 연결된 지점 1
                    int E = Integer.parseInt(st.nextToken()); // 연결된 지점 2
                    int T = Integer.parseInt(st.nextToken()); // 도로를 이동하는데 걸린 시간
                    graph[S].add(new Edge(E, T));
                    graph[E].add(new Edge(S, T));
                }

                for (int w = 0; w < W; w++) {
                    st = new StringTokenizer(br.readLine());
                    int S = Integer.parseInt(st.nextToken()); // 연결된 지점 1
                    int E = Integer.parseInt(st.nextToken()); // 연결된 지점 2
                    int T = Integer.parseInt(st.nextToken()); // 줄어든 시간
                    graph[S].add(new Edge(E, -T));
                }

                boolean hasCycle = bellmanFord(N);

                if (hasCycle) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean bellmanFord(int N) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        boolean update = false;
        // (정점 -1) 번 동안 최단거리 초기화 작업 실행
        for (int i = 1; i < N; i++) {
            update = false;

            // 최단거리 초기화
            for (int j = 1; j <= N; j++) {
                for (Edge edge : graph[j]) {
                    if (dist[edge.end] > dist[j] + edge.time) {
                        dist[edge.end] = dist[j] + edge.time;
                        update = true;
                    }
                }
            }

            // 더이상 변화가 발생하지 않으면 종료
            if (!update) {
                break;
            }
        }

        // (정점 수 -1)번의 수행 이후에도 업데이트가 발생하면 음의 사이클이 존재하는 것!!
        if (update) {
            for (int j = 1; j <= N; j++) {
                for (Edge edge : graph[j]) {
                    if (dist[j] != INF && dist[edge.end] > dist[j] + edge.time) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static class Edge {
        int end;
        int time;

        public Edge(int end, int time) {
            this.end = end;
            this.time = time;
        }
    }
}

/*
Input
2
3 3 1
1 2 2
1 3 4
2 3 1
3 1 3
3 2 1
1 2 3
2 3 4
3 1 8

Output
NO
YES
*/
