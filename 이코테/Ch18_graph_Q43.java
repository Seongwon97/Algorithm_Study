package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 어두운 길
public class Ch18_graph_Q43 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int distance = Integer.parseInt(st.nextToken());
                edges.add(new Edge(x, y, distance));
            }

            Collections.sort(edges);

            int totalWeight = 0;
            for (Edge edge : edges) {
                totalWeight += edge.weight;
            }

            int requiredDistance = kruskal(edges, N);

            System.out.println(totalWeight - requiredDistance);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int kruskal(List<Edge> edges, int numOfNodes) {
        int[] parents = new int[numOfNodes + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        int totalRequiredWeight = 0;
        for (Edge edge : edges) {
            if (findParent(parents, edge.node1) != findParent(parents, edge.node2)) {
                totalRequiredWeight += edge.weight;
                unionParent(parents, edge.node1, edge.node2);
            }
        }

        return totalRequiredWeight;
    }

    private static void unionParent(int[] parents, int a, int b) {
        int parentA = findParent(parents, a);
        int parentB = findParent(parents, b);

        if (parentA < parentB) {
            parents[parentB] = parentA;
        } else {
            parents[parentA] = parentB;
        }
    }

    private static int findParent(int[] parents, int a) {
        if (parents[a] != a) {
            parents[a] = findParent(parents, parents[a]);
        }
        return parents[a];
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
7 11
0 1 7
0 3 5
1 2 8
1 3 9
1 4 7
2 4 5
3 4 15
3 5 6
4 5 8
4 6 9
5 6 11

Output
51
*/
