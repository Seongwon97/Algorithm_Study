package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2458
// 키 순서
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // CASE 수

        boolean[][] canCompare = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int smaller = Integer.parseInt(st.nextToken());
            int taller = Integer.parseInt(st.nextToken());
            canCompare[smaller][taller] = true;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (canCompare[i][k] && canCompare[k][j]) {
                        canCompare[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (canCompare[i][j] || canCompare[j][i]) {
                    count++;
                }
            }

            if (count == N - 1) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
/*
Input
6 6
1 5
3 4
5 4
4 2
4 6
5 2

Output
1
---
Input
6 7
1 3
1 5
3 4
5 4
4 2
4 6
5 2

Output
2
*/
