package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16947
// 서울 지하철 2호선
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map.get(start).add(end);
            map.get(end).add(start);
        }

        boolean[] hasCycle = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (checkCycle(map, hasCycle, i, i, i)) {
                break;
            }
            hasCycle = new boolean[N + 1];
        }

        int[] result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            result[i] = bfs(map, hasCycle, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }

    private static int bfs(Map<Integer, List<Integer>> map, boolean[] hasCycle, int node) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[map.size() + 1];
        queue.add(new Node(node, 0));
        visited[node] = true;
        while (!queue.isEmpty()) {
            Node polled = queue.poll();
            if (hasCycle[polled.id]) {
                return polled.numOfMoved;
            }

            for (int next : map.get(polled.id)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new Node(next, polled.numOfMoved + 1));
                }
            }
        }

        return 0;
    }

    public static boolean checkCycle(Map<Integer, List<Integer>> map, boolean[] hasCycle, int prev, int current,
                                     int start) {
        hasCycle[current] = true;
        for (int i = 0; i < map.get(current).size(); i++) {
            int next = map.get(current).get(i);

            if (prev == next) {
                continue;
            }

            if (!hasCycle[next] && checkCycle(map, hasCycle, current, next, start)) {
                return true;
            }

            if (next == start) {
                return true;
            }
        }
        hasCycle[current] = false;

        return false;
    }

    public static class Node {
        int id;
        int numOfMoved;

        public Node(int id, int numOfMoved) {
            this.id = id;
            this.numOfMoved = numOfMoved;
        }
    }
}
/*
Input
4
1 3
4 3
4 2
1 2

Output
0 0 0 0
---
Input
6
1 2
3 4
6 4
2 3
1 3
3 5

Output
0 0 0 1 1 2
*/
