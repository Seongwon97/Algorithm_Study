package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 트리의 지름
// https://www.acmicpc.net/problem/1167
public class B1167 {

    private static List<Node>[] nodeInfo;
    private static int longestDistance = 0;
    private static int endPoint = -1;
    private static int V;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            V = Integer.parseInt(br.readLine());

            nodeInfo = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) {
                nodeInfo[i] = new ArrayList<>();
            }

            for (int i = 0; i < V; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                while (true) {
                    int end = Integer.parseInt(st.nextToken());
                    if (end == -1) {
                        break;
                    }
                    int distance = Integer.parseInt(st.nextToken());

                    nodeInfo[start].add(new Node(end, distance));
                }
            }

            boolean[] visited = new boolean[V + 1];
            // 임의의 지점에서 최장거리 구하기
            dfs(visited, 1, 0);

            // 앞서 구한 임의의 지점의 endPoint를 통해 최장거리 구하기
            visited = new boolean[V + 1];
            dfs(visited, endPoint, 0);

            System.out.println(longestDistance);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void dfs(boolean[] visited, int current, int distance) {
        if (longestDistance < distance) {
            longestDistance = distance;
            endPoint = current;
        }
        visited[current] = true;

        for (Node node : nodeInfo[current]) {
            if (!visited[node.id]) {
                dfs(visited, node.id, distance + node.distance);
                visited[node.id] = true;
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
5
1 3 2 -1
2 4 4 -1
3 1 2 4 3 -1
4 2 4 3 3 5 6 -1
5 4 6 -1

Output
11
*/
