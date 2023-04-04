import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;

        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        List<Edge> edges = new ArrayList<>();
        for (int[] cost : costs) {
            edges.add(new Edge(cost[0], cost[1], cost[2]));
        }

        Collections.sort(edges);

        for (Edge edge : edges) {
            if (findParent(parents, edge.node1) != findParent(parents, edge.node2)) {
                unionParent(parents, edge.node1, edge.node2);
                answer += edge.weight;
            }
        }

        return answer;
    }

    private static int findParent(int[] parents, int node) {
        if (parents[node] != node) {
            parents[node] = findParent(parents, parents[node]);
        }
        return parents[node];
    }

    private static void unionParent(int[] parents, int node1, int node2) {
        int parent1 = findParent(parents, node1);
        int parent2 = findParent(parents, node2);

        if (parent1 < parent2) {
            parents[parent2] = parent1;
        } else {
            parents[parent1] = parent2;
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
