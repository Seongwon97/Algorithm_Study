package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2960
// 에라토스테네스의 체
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(findAnswer(N, K));
    }

    private static int findAnswer(int N, int K) {
        int eraseCount = 1;
        boolean[] isErased = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            if (isErased[i]) {
                continue;
            }

            for (int j = i; j <= N; j += i) {
                if (!isErased[j]) {
                    if (eraseCount == K) {
                        return j;
                    }
                    isErased[j] = true;
                    eraseCount++;
                }
            }
        }
        return 0;
    }
}
/*
Input
7 3

Output
6
*/
