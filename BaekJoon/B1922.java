package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1922
// 네트워크 연결
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] parents = new int[N + 1];
        for (int i = 1; i < N; i++) {
            parents[i] = i;
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(node1, node2, weight));
        }

        int answer = 0;
        while (!edges.isEmpty()) {
            Edge e = edges.poll();
            if (findParent(parents, e.node1) != findParent(parents, e.node2)) {
                answer += e.weight;
                unionParent(parents, e.node1, e.node2);
            }
        }

        System.out.println(answer);
    }

    private static int findParent(int[] parents, int x) {
        if (parents[x] != x) {
            parents[x] = findParent(parents, parents[x]);
        }
        return parents[x];
    }

    private static void unionParent(int[] parents, int x, int y) {
        int a = findParent(parents, x);
        int b = findParent(parents, y);

        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
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
6
9
1 2 5
1 3 4
2 3 2
2 4 7
3 4 6
3 5 11
4 5 3
4 6 8
5 6 8

Output
23
*/
