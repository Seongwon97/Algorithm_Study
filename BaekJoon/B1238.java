package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 파티
// https://www.acmicpc.net/problem/1238
public class B1238 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 지점의 수
            int M = Integer.parseInt(st.nextToken()); // 도로의 수
            int X = Integer.parseInt(st.nextToken()); // 모임 장소

            List<List<Node>> graph = new ArrayList<>();
            List<List<Node>> reversedGraph = new ArrayList<>();

            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
                reversedGraph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                graph.get(start).add(new Node(end, time));
                reversedGraph.get(end).add(new Node(start, time));
            }

            int[] result1 = dijkstra(graph, N, X);
            int[] result2 = dijkstra(reversedGraph, N, X);

            int answer = 0;
            for (int i = 1; i <= N; i++) {
                answer = Math.max(answer, result1[i] + result2[i]);
            }

            System.out.println(answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] dijkstra(List<List<Node>> graph, int N, int X) {
        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[X] = 0;

        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(X, 0));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (!visited[currentNode.end]) {
                visited[currentNode.end] = true;
            }

            for (Node node : graph.get(currentNode.end)) {
                if (!visited[node.end] && distance[node.end] > distance[currentNode.end] + node.time) {
                    distance[node.end] = distance[currentNode.end] + node.time;
                    queue.add(new Node(node.end, distance[node.end]));
                }
            }
        }
        return distance;
    }

    private static class Node implements Comparable<Node> {
        int end;
        int time;

        public Node(int end, int time) {
            this.end = end;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
}

/*
Input
4 8 2
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3

Output
10
*/
