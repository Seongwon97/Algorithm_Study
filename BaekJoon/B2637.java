package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2637
// 장난감 조립
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] numOfParts = new int[N + 1][N + 1];

        Map<Integer, List<Part>> parts = new HashMap<>();
        for (int i = 0; i <= N; i++) {
            parts.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // X를 만드는데 Y가 K개 필요하다
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            parts.get(X).add(new Part(Y, K));
        }

        boolean[] visited = new boolean[N + 1];
        findPart(N, N, parts, numOfParts, visited);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= N; i++) {
            if (numOfParts[N][i] != 0) {
                sb.append(i)
                        .append(" ")
                        .append(numOfParts[N][i])
                        .append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void findPart(int N, int current, Map<Integer, List<Part>> parts, int[][] numOfParts,
                                 boolean[] visited) {
        if (visited[current]) {
            return;
        }

        boolean isBasicPart = true;
        for (Part part : parts.get(current)) {
            isBasicPart = false;
            findPart(N, part.id, parts, numOfParts, visited);
        }

        if (isBasicPart) {
            numOfParts[current][current] = 1;
        }

        for (Part part : parts.get(current)) {
            for (int i = 1; i <= N; i++) {
                numOfParts[current][i] += (numOfParts[part.id][i] * part.amount);
            }
        }
        visited[current] = true;
    }

    static class Part {
        int id;
        int amount;

        public Part(int id, int amount) {
            this.id = id;
            this.amount = amount;
        }
    }
}
/*
Input
7
8
5 1 2
5 2 2
7 5 2
6 5 2
6 3 3
6 4 4
7 6 3
7 4 5

Output
1 16
2 16
3 9
4 17
*/
