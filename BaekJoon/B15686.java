package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 치킨 배달 (구현)
// https://www.acmicpc.net/problem/15686
public class B15686 {

    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List<Node> chickenHouse = new ArrayList<>();
            List<Node> house = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int info = Integer.parseInt(st.nextToken());
                    if (info == 1) {
                        house.add(new Node(i, j));
                    } else if (info == 2) {
                        chickenHouse.add(new Node(i, j));
                    }
                }
            }
            boolean[] visited = new boolean[chickenHouse.size()];
            backtracking(M, chickenHouse, house, visited, 0, 0);
            System.out.println(minDistance);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void backtracking(int m, List<Node> chickenHouse, List<Node> hose, boolean[] visited, int count, int idx) {
        if (count == m) {
            int totalDistance = 0;
            for (Node node : hose) {
                int sum = Integer.MAX_VALUE;
                for (int j = 0; j < chickenHouse.size(); j++) {
                    if (visited[j]) {
                        int dist = Math.abs(node.x - chickenHouse.get(j).x)
                                + Math.abs(node.y - chickenHouse.get(j).y);
                        sum = Math.min(sum, dist);
                    }
                }
                totalDistance += sum;
            }
            minDistance = Math.min(totalDistance, minDistance);
            return;
        }

        for (int i = idx; i < chickenHouse.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(m, chickenHouse, hose, visited, count + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
