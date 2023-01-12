package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질
public class Ch17_shortest_distance_Q40 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < N + 1; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
            }

            int[] distances = dijkstra(graph, N);
            int farthestPosition = 0;
            int farthestDistance = 0;
            int sameDistancePosition = 0;
            for (int i = 1; i < N + 1; i++) {
                if (distances[i] > farthestDistance) {
                    farthestPosition = i;
                    farthestDistance = distances[i];
                    sameDistancePosition = 1;
                } else if (distances[i] == farthestDistance) {
                    sameDistancePosition++;
                }
            }

            System.out.println(farthestPosition + " " + farthestDistance + " " + sameDistancePosition);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] dijkstra(List<List<Integer>> graph, int n) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[1] = 0;

        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(1, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (distances[node.id] < node.weight) {
                continue;
            }

            for (int id : graph.get(node.id)) {
                int weight = node.weight + 1;
                if (weight < distances[id]) {
                    distances[id] = weight;
                    queue.offer(new Node(id, weight));
                }
            }
        }

        return distances;
    }

    private static class Node implements Comparable<Node> {
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
6 7
3 6
4 3
3 2
1 3
1 2
2 4
5 2

Output
4 2 3
*/
