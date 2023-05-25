package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1025
// 제곱수 찾기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] table = new int[10][10];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                table[i][j] = line.charAt(j) - '0';
            }
        }

        int result = -1;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                for (int mi = -N; mi < N; ++mi) {
                    for (int mj = -M; mj < M; ++mj) {
                        if (mi == 0 && mj == 0) { // 둘다 움직이지 않을 때
                            continue;
                        }

                        int now = 0;
                        int newI = i;
                        int newJ = j;
                        while (newI >= 0 && newI < N && newJ >= 0 && newJ < M) // 위치가 0>= && <범위를 설정해줍니다.
                        {
                            now = 10 * now + table[newI][newJ]; // 기존에 담긴 숫자가 있다면 *10해주고 더해줍니다.

                            int root = (int) Math.sqrt(now);
                            if (Math.pow(root, 2) == now) { // 완전 제곱수인지 판별합니다.
                                result = Math.max(result, now);
                            }

                            newI += mi;
                            newJ += mj;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
/*
Input
2 3
123
456

Output
64
---
Input
5 5
00000
00000
00200
00000
00000

Output
0
---
Input
6 7
3791178
1283252
4103617
8233494
8725572
2937261

Output
320356
*/
