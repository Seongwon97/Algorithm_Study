package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1484
// 다이어트
public class Main {
    private static final int DIVISOR = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long low = 1;
        long high = 2;

        StringBuilder sb = new StringBuilder();
        boolean isExist = false;
        while (high < 100_000) {
            long sl = low * low;
            long sh = high * high;
            if (sh - sl == N) {
                sb.append(high)
                        .append("\n");
                isExist = true;
            }

            if (sh - sl > N) {
                low++;
            } else {
                high++;
            }
        }

        if (!isExist) {
            sb.append(-1);
        }

        System.out.println(sb);
    }
}
/*
Input
15

Output
4
8
*/
