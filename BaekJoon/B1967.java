package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 트리의 지름
// https://www.acmicpc.net/problem/1967
public class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            graph[parent].add(new Node(child, distance));
            graph[child].add(new Node(parent, distance));
        }

        List<Integer> leafs = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (graph[i].size() == 1) {
                leafs.add(i);
            }
        }

        boolean[] visited = new boolean[n + 1];
        for (int leaf : leafs) {
            visited[leaf] = true;
            dfs(graph, visited, leaf, leaf, 0);
            visited[leaf] = false;
        }
        System.out.println(answer);
    }

    private static void dfs(ArrayList<Node>[] graph, boolean[] visited, int start, int current, int distance) {
        if (graph[current].size() == 1 && start != current) {
            answer = Math.max(answer, distance);
            return;
        }

        for (Node node : graph[current]) {
            if (!visited[node.id]) {
                visited[node.id] = true;
                dfs(graph, visited, start, node.id, distance + node.distance);
                visited[node.id] = false;
            }
        }
    }

    static class Node {
        int id;
        int distance;

        public Node(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }
    }
}
/*
Input
2
5 4 2
1 2 3
1 2 6
2 3 2
3 4 4
3 5 3
5
4
6 9 2
2 3 1
1 2 1
1 3 3
2 4 4
2 5 5
3 4 3
3 6 2
4 5 4
4 6 3
5 6 7
5
6

Output
4 5
6
*/
