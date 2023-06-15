package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/17425
// 약수의 합
public class Main {
    private static final int MAX_RANGE = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] fx = new long[MAX_RANGE];
        for (int i = 1; i < MAX_RANGE; i++) {
            for (int j = i; j < MAX_RANGE; j += i) {
                fx[j] += i;
            }
        }

        long[] cumulativeSum = new long[MAX_RANGE];
        for (int i = 1; i < MAX_RANGE; i++) {
            cumulativeSum[i] = cumulativeSum[i - 1] + fx[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(cumulativeSum[N]).append("\n");
        }

        System.out.println(sb);
    }
}
/*
Input
5
1
2
10
70
10000

Output
1
4
87
4065
82256014
*/
