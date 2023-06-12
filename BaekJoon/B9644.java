package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/9466
// 텀 프로젝트
public class Main {
    private static int numOfCycleElements = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] choices = new int[N + 1];
            numOfCycleElements = 0;
            for (int j = 1; j <= N; j++) {
                choices[j] = Integer.parseInt(st.nextToken());
            }

            boolean[] visited = new boolean[N + 1];
            boolean[] finished = new boolean[N + 1];
            for (int j = 1; j <= N; j++) {
                dfs(visited, finished, choices, j);
            }

            System.out.println(N - numOfCycleElements);
        }
    }

    private static void dfs(boolean[] visited, boolean[] finished, int[] choice, int current) {
        if (visited[current]) {
            return;
        }

        visited[current] = true;
        int next = choice[current];

        if (!visited[next]) {
            dfs(visited, finished, choice, next);
        } else {
            if (!finished[next]) { // 누군가는 무조건 사이클을 가짐
                numOfCycleElements++;
                for (int i = next; i != current; i = choice[i]) {
                    numOfCycleElements++;
                }
            }
        }

        finished[current] = true;
    }
}
/*
Input
2
7
3 1 3 7 3 4 6
8
1 2 3 4 5 6 7 8

Output
3
0
*/
