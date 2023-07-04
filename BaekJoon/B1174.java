package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.acmicpc.net/problem/1174
// 줄어드는 수
public class Main {
    private static final int[] NUMBERS = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Long> decreaseNumbers = new ArrayList<>();

        dfs(decreaseNumbers, 0, 0);
        Collections.sort(decreaseNumbers);

        if (N <= decreaseNumbers.size()) {
            System.out.println(decreaseNumbers.get(N - 1));
        } else {
            System.out.println(-1);
        }
    }

    private static void dfs(List<Long> decreaseNumbers, long current, int nextIdx) {
        if (!decreaseNumbers.contains(current)) {
            decreaseNumbers.add(current);
        }

        if (nextIdx >= 10) {
            return;
        }

        dfs(decreaseNumbers, current * 10 + NUMBERS[nextIdx], nextIdx + 1);
        dfs(decreaseNumbers, current, nextIdx + 1);
    }
}
/*
Input
1

Output
0
---
Input
19

Output
42
---
Input
500000

Output
-1
*/
