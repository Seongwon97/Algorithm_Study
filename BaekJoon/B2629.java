package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2629
// 양팔저울
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfWeight = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] weights = new int[numOfWeight + 1];
        for (int i = 1; i <= numOfWeight; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] isAvailable = new boolean[31][15001];
        dfs(0, numOfWeight, 0, weights, isAvailable);

        StringBuilder sb = new StringBuilder();
        int numOfBall = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numOfBall; i++) {
            int ball = Integer.parseInt(st.nextToken());
            if (ball > 15000) {
                sb.append("N ");
            } else {
                if (isAvailable[numOfWeight][ball]) {
                    sb.append("Y ");
                } else {
                    sb.append("N ");
                }
            }
        }

        System.out.println(sb);
    }

    public static void dfs(int idx, int maxIdx, int currentWeight, int[] weights, boolean[][] isAvailable) {
        if (isAvailable[idx][currentWeight]) {
            return;
        }
        isAvailable[idx][currentWeight] = true;

        if (idx == maxIdx) {
            return;
        }

        dfs(idx + 1, maxIdx, currentWeight + weights[idx + 1], weights, isAvailable);
        dfs(idx + 1, maxIdx, currentWeight, weights, isAvailable);
        dfs(idx + 1, maxIdx, Math.abs(currentWeight - weights[idx + 1]), weights, isAvailable);
    }
}
/*
Input
2
1 4
2
3 2

Output
Y N
---
Input
4
2 3 3 3
3
1 4 10

Output
Y Y N
*/
