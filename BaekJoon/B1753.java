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

// https://www.acmicpc.net/problem/1753
// 최단경로
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        Map<Integer, List<Edge>> map = new HashMap<>();
        for (int i = 1; i <= V; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            map.get(node1).add(new Edge(node2, weight));
        }

        int[] shortestDistance = dijkstra(start, V, map);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (shortestDistance[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(shortestDistance[i])
                        .append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int[] dijkstra(int start, int V, Map<Integer, List<Edge>> map) {
        int[] shortestDistance = new int[V + 1];
        Arrays.fill(shortestDistance, Integer.MAX_VALUE);
        shortestDistance[start] = 0;

        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (shortestDistance[node.id] < node.weight) {
                continue;
            }

            for (Edge edge : map.get(node.id)) {
                int weight = node.weight + edge.distance;
                if (weight < shortestDistance[edge.destination]) {
                    shortestDistance[edge.destination] = weight;
                    queue.add(new Node(edge.destination, weight));
                }
            }
        }

        return shortestDistance;
    }

    static class Edge {
        int destination;
        int distance;

        public Edge(int destination, int distance) {
            this.destination = destination;
            this.distance = distance;
        }
    }

    static class Node implements Comparable<Node> {
        int id;
        int weight;

        public Node(int id, int weight) {
            this.id = id;
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
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6

Output
0
2
3
7
INF
*/
