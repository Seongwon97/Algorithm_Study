package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1138
// 한 줄로 서기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] heights = new int[N + 1];
        List<Integer> answer = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i >= 1; i--) {
            answer.add(heights[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int h : answer) {
            sb.append(h)
                    .append(" ");
        }

        System.out.println(sb);
    }
}
/*
Input
4
2 1 1 0

Output
4 2 1 3
---
Input
5
0 0 0 0 0

Output
1 2 3 4 5
---
Input
6
5 4 3 2 1 0

Output
6 5 4 3 2 1
*/
