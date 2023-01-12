package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 여행 계획
public class Ch18_graph_Q41 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] parent = new int[N + 1];
            for (int i = 1; i < N + 1; i++) {
                parent[i] = i;
            }
            for (int i = 1; i < N + 1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < N + 1; j++) {
                    int weight = Integer.parseInt(st.nextToken());
                    if (weight == 1) {
                        unionParent(parent, i, j);
                    }
                }
            }

            int[] plans = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                plans[i] = Integer.parseInt(st.nextToken());
            }

            boolean isPossible = true;
            for (int i = 1; i < M; i++) {
                if (findParent(parent, plans[i - 1]) != findParent(parent, plans[i])) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
            parents[node2] = parent1;
        } else {
            parents[node1] = node2;
        }
    }
}

/*
Input
5 4
0 1 0 1 1
1 0 1 1 0
0 1 0 0 0
1 1 0 0 0
1 0 0 0 0
2 3 4 3

Output
YES
*/
