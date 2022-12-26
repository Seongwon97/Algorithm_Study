package chapter3_greedy;

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

// 전보 (Dijkstra)
public class Ch9_shortest_distance_ex2_Dijkstra {

    private static final int MAX_TIME = 1001;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 도시의 수
            int M = Integer.parseInt(st.nextToken()); // 통로의 수
            int C = Integer.parseInt(st.nextToken()); // 메시지를 보낼 도시

            Map<Integer, List<Node>> graph = new HashMap<>();
            for (int i = 1; i < N + 1; i++) {
                graph.put(i, new ArrayList<>());
            }

            int[] distances = new int[N];
            Arrays.fill(distances, MAX_TIME);

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                List<Node> nodes = graph.get(a);
                nodes.add(new Node(b, d));
            }

            int[] result = dijkstra(graph, C);
            int count = 0;
            int maxDistance = 0;
            for (int r : result) {
                if (r != Integer.MAX_VALUE) {
                    count += 1;
                    maxDistance = Math.max(r, maxDistance);
                }
            }
            System.out.println((count - 1) + " " + maxDistance);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] dijkstra(Map<Integer, List<Node>> graph, int start) {
        Queue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[graph.size() + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (distance[node.vertex] < node.weight) {
                continue;
            }

            for (Node searchNode : graph.get(node.vertex)) {
                int newWeight = searchNode.weight + node.weight;
                if (newWeight < distance[searchNode.vertex]) {
                    distance[searchNode.vertex] = newWeight;
                    pq.offer(new Node(searchNode.vertex, newWeight));
                }
            }
        }

        return distance;
    }

    public static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
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
3 2 1
1 2 4
1 3 2

Output 2 4
 */
