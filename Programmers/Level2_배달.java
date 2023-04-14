import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        Map<Integer, List<Node>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] r : road) {
            map.get(r[0]).add(new Node(r[1], r[2]));
            map.get(r[1]).add(new Node(r[0], r[2]));
        }

        int[] distance = dijkstra(map, N, 1);

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

    private int[] dijkstra(Map<Integer, List<Node>> map, int N, int start) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        Queue<Node> queue = new PriorityQueue<>();
        queue.addAll(map.get(start));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (distance[node.id] > node.weight) {
                distance[node.id] = node.weight;
                for (Node n : map.get(node.id)) {
                    n.weight = n.weight + distance[node.id];
                    queue.add(n);
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
