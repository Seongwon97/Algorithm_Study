package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 도시 분할 계획 (Kruskal)
public class Ch10_graph_ex2_Kruskal {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] parent = new int[N + 1];
            for (int i = 0; i < N + 1; i++) {
                parent[i] = i;
            }

            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                edges.add(new Edge(a, b, c));
            }

            int result = kruskal(edges, parent);
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int kruskal(List<Edge> edges, int[] parent) {
        int result = 0;
        int lastCost = 0;
        Collections.sort(edges);
        for (Edge edge : edges) {
            if (findParent(parent, edge.vertex1) != findParent(parent, edge.vertex2)) {
                unionParent(parent, edge.vertex1, edge.vertex2);
                result += edge.cost;
                lastCost = edge.cost;
            }
        }
        return result - lastCost;
    }

    private static int findParent(int[] parent, int a) {
        if (parent[a] != a) {
            parent[a] = findParent(parent, parent[a]);
        }
        return parent[a];
    }

    private static void unionParent(int[] parent, int a, int b) {
        int parentA = findParent(parent, a);
        int parentB = findParent(parent, b);

        if (parentA < parentB) {
            parent[parentB] = parentA;
        } else {
            parent[parentA] = parentB;
        }
    }

    static class Edge implements Comparable<Edge> {
        int vertex1;
        int vertex2;
        int cost;

        public Edge(int vertex1, int vertex2, int cost) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
/*
Input
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4

Output
8
 */
