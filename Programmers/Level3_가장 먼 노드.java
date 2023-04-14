import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] e : edge) {
            graph.get(e[0]).add(new Node(e[1], 1));
            graph.get(e[1]).add(new Node(e[0], 1));
        }

        int[] distance = dijkstra(graph, n, 1);

        int max = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (max < distance[i]) {
                count = 1;
                max = distance[i];
            } else if (max == distance[i]) {
                count++;
            }
        }

        return count;
    }

    private int[] dijkstra(Map<Integer, List<Node>> graph, int n, int start) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        boolean[] visited = new boolean[n + 1];

        Queue<Node> queue= new PriorityQueue<>();
        queue.addAll(graph.get(start));
        while (!queue.isEmpty()) {
            Node polled = queue.poll();
            visited[polled.id] = true;
            if (distance[polled.id] > polled.weight) {
                distance[polled.id] = polled.weight;
                for (Node node : graph.get(polled.id)) {
                    if (visited[node.id]) {
                        continue;
                    }
                    queue.add(new Node(node.id, node.weight + distance[polled.id]));
                }
            }
        }
        return distance;
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
