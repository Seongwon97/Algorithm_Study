package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1504
// 특정한 최단 경로
public class Main {
    private static final int INF = 200_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> N
        int startToV1 = dijkstra(N, graph, 1, v1);
        int v1ToV2 = dijkstra(N, graph, v1, v2);
        int v2ToN = dijkstra(N, graph, v2, N);
        int route1 = startToV1 + v1ToV2 + v2ToN;

        // 1 -> v2 -> v1 -> N
        int startToV2 = dijkstra(N, graph, 1, v2);
        int v2ToV1 = dijkstra(N, graph, v2, v1);
        int v1ToN = dijkstra(N, graph, v1, N);
        int route2 = startToV2 + v2ToV1 + v1ToN;

        int answer = Math.min(route1, route2);

        if (answer >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static int dijkstra(int N, Map<Integer, List<Edge>> graph, int start, int end) {
        int[] minDistance = new int[N + 1];
        Arrays.fill(minDistance, INF);
        minDistance[start] = 0;

        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (minDistance[edge.destination] < edge.weight) {
                continue;
            }

            minDistance[edge.destination] = edge.weight;
            for (Edge nextEdge : graph.get(edge.destination)) {
                int newWeight = edge.weight + nextEdge.weight;
                if (newWeight < minDistance[nextEdge.destination]) {
                    minDistance[nextEdge.destination] = newWeight;
                    pq.add(new Edge(nextEdge.destination, newWeight));
                }
            }
        }

        return minDistance[end];
    }

    static class Edge implements Comparable<Edge> {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }
}
/*
Input
4 6
1 2 3
2 3 3
3 4 1
1 3 5
2 4 5
1 4 4
2 3

Output
7
*/
