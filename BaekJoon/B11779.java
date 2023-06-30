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

// https://www.acmicpc.net/problem/11779
// 최소비용 구하기 2
public class Main {
    private static int minDistance = 0;
    private static List<Integer> reversedRoute = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Edge(end, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(graph, start, end);

        StringBuilder sb = new StringBuilder();
        sb.append(minDistance).append("\n");
        sb.append(reversedRoute.size()).append("\n");

        for (int i = reversedRoute.size() - 1; i >= 0; i--) {
            sb.append(reversedRoute.get(i)).append(" ");
        }

        System.out.println(sb);
    }

    private static void dijkstra(Map<Integer, List<Edge>> graph, int start, int end) {
        int[] distance = new int[graph.size() + 1];
        int[] previousCity = new int[graph.size() + 1];
        previousCity[start] = start;
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        Queue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(start, 0));
        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            if (distance[current.destination] < current.weight) {
                continue;
            }

            for (Edge next : graph.get(current.destination)) {
                int weight = distance[current.destination] + next.weight;
                if (weight < distance[next.destination]) {
                    distance[next.destination] = weight;
                    previousCity[next.destination] = current.destination;
                    queue.add(new Edge(next.destination, weight));
                }
            }
        }

        minDistance = distance[end];
        int currentPosition = end;
        while (previousCity[currentPosition] != currentPosition) {
            reversedRoute.add(currentPosition);
            currentPosition = previousCity[currentPosition];
        }
        reversedRoute.add(currentPosition);
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
3
1 3 5

OR

4
3
1 4 5
*/
