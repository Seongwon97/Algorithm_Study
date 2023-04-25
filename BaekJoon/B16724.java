package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16724
// 피리 부는 사나이
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] matrix = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            matrix[i] = str.toCharArray();
        }

        int answer = 0;
        int nextCycle = 0;
        int[][] cycle = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cycle[i][j] == 0) {
                    nextCycle++;
                    answer++;
                    int x = i;
                    int y = j;
                    while (cycle[x][y] == 0) {
                        cycle[x][y] = nextCycle;
                        if (matrix[x][y] == 'U') {
                            x--;
                        } else if (matrix[x][y] == 'D') {
                            x++;
                        } else if (matrix[x][y] == 'R') {
                            y++;
                        } else {
                            y--;
                        }
                        if (x < 0 || x >= N || y < 0 || y >= M) {
                            break;
                        }

                        // 이전 사이클에 포함되는 경우 safe zone -1
                        if (cycle[x][y] != 0 && cycle[x][y] < nextCycle) {
                            answer--;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
/*
Input
3 4
DLLL
DRLU
RRRU

Output
2
---
Input
10 10
DRDRRRRRRD
RDRUDUUUUL
URLDLRRRRD
RRRRLRDLUD
DDRLLDULUU
DRULLLRDUU
DULLDDDURU
URLDDDDUUL
DLRLRDUULL
RRULRUUURU

Output
12
*/

