package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10423
// 전기가 부족해
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int city = Integer.parseInt(st.nextToken());
            parents[city] = -1;
        }

        Queue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new Edge(node1, node2, weight));
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (findParent(parents, edge.node1) != findParent(parents, edge.node2)) {
                unionParent(parents, edge.node1, edge.node2);
                answer += edge.weight;
            }
        }

        System.out.println(answer);
    }

    private static int findParent(int[] parents, int node) {
        if (parents[node] == -1) {
            return -1;
        }

        if (parents[node] != node) {
            parents[node] = findParent(parents, parents[node]);
        }
        return parents[node];
    }

    private static void unionParent(int[] parents, int node1, int node2) {
        node1 = findParent(parents, node1);
        node2 = findParent(parents, node2);

        if (node1 == -1) {
            parents[node2] = node1;
        } else if (node2 == -1) {
            parents[node1] = node2;
        } else if (node1 != node2) {
            parents[node2] = node1;
        }
    }

    static class Edge implements Comparable<Edge> {
        int node1;
        int node2;
        int weight;

        public Edge(int node1, int node2, int weight) {
            this.node1 = node1;
            this.node2 = node2;
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
9 14 3
1 2 9
1 3 3
1 4 8
2 4 10
3 4 11
3 5 6
4 5 4
4 6 10
5 6 5
5 7 4
6 7 7
6 8 4
7 8 5
7 9 2
8 9 5

Output
22
---
Input
4 5 1
1
1 2 5
1 3 5
1 4 5
2 3 10
3 4 10

Output
15
*/
