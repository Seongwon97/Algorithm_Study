package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 행성 터널
// https://www.acmicpc.net/problem/2887
public class Ch18_graph_Q44 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            Node[] nodes = new Node[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                nodes[i] = new Node(i, x, y, z);
            }

            List<Edge> edges = new ArrayList<>();
            // x 축 정렬 후, 만들어진 edge 추가
            Arrays.sort(nodes, Comparator.comparingInt(o -> o.x));
            for (int i = 0; i < N - 1; i++) {
                edges.add(new Edge(nodes[i].id, nodes[i + 1].id, Math.abs((nodes[i].x - nodes[i + 1].x))));
            }

            // y 축 정렬 후, 만들어진 edge 추가
            Arrays.sort(nodes, Comparator.comparingInt(o -> o.y));
            for (int i = 0; i < N - 1; i++) {
                edges.add(new Edge(nodes[i].id, nodes[i + 1].id, Math.abs((nodes[i].y - nodes[i + 1].y))));
            }

            // z 축 정렬 후, 만들어진 edge 추가
            Arrays.sort(nodes, Comparator.comparingInt(o -> o.z));
            for (int i = 0; i < N - 1; i++) {
                edges.add(new Edge(nodes[i].id, nodes[i + 1].id, Math.abs((nodes[i].z - nodes[i + 1].z))));
            }

            Collections.sort(edges);

            int cost = kruskal(edges, N);

            System.out.println(cost);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int kruskal(List<Edge> edges, int numOfPlanets) {
        int[] parents = new int[numOfPlanets];
        for (int i = 0; i < numOfPlanets; i++) {
            parents[i] = i;
        }

        int cost = 0;
        for (Edge edge : edges) {
            int parentNode1 = findParent(parents, edge.node1);
            int parentNode2 = findParent(parents, edge.node2);
            if (parentNode1 != parentNode2) {
                unionParent(parents, parentNode1, parentNode2);
                cost += edge.weight;
            }
        }

        return cost;
    }

    private static int findParent(int[] parents, int a) {
        if (parents[a] != a) {
            parents[a] = findParent(parents, parents[a]);
        }
        return parents[a];
    }

    private static void unionParent(int[] parents, int parentA, int parentB) {
        if (parentA < parentB) {
            parents[parentB] = parentA;
        } else {
            parents[parentA] = parentB;
        }
    }

    static class Node {
        int id;
        int x;
        int y;
        int z;

        public Node(int id, int x, int y, int z) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.z = z;
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
5
11 -15 -15
14 -5 -15
-1 -1 -5
10 -4 -1
19 -4 19

Output
4
*/
