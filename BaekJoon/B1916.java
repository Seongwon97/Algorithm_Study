package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1916
// 최소비용 구하기
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int origin = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(origin).add(new Edge(destination, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int origin = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        int answer = dijkstra(N, origin, destination, graph);

        System.out.println(answer);
    }

    private static int dijkstra(int N, int origin, int destination, Map<Integer, List<Edge>> graph) {
        int[] minWeight = new int[N + 1];
        Arrays.fill(minWeight, Integer.MAX_VALUE);

        Queue<Edge> queue = new PriorityQueue<>();
        queue.addAll(graph.get(origin));
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            if (minWeight[edge.destination] > edge.weight) {
                minWeight[edge.destination] = edge.weight;
                for (Edge e : graph.get(edge.destination)) {
                    queue.add(new Edge(e.destination, edge.weight + e.weight));
                }
            }
        }

        return minWeight[destination];
    }

    static class Edge implements Comparable<Edge> {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
/*
Input
5
8
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
1 5

Output
4
*/
