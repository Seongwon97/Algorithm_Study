package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11725
// 트리의 부모 찾기
public class Main {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        parents = new int[N + 1];

        dfs(graph, 1);

        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void dfs(Map<Integer, List<Integer>> graph, int currentNode) {
        List<Integer> nodes = graph.get(currentNode);
        for (int node : nodes) {
            if (parents[node] == 0) {
                parents[node] = currentNode;
                dfs(graph, node);
            }
        }
    }
}
/*
Input
7
1 6
6 3
3 5
4 1
2 4
4 7

Output
4
6
1
3
1
4

---
Input
12
1 2
1 3
2 4
3 5
3 6
4 7
4 8
5 9
5 10
6 11
6 12

Output
1
1
2
3
3
4
4
5
5
6
6
*/
