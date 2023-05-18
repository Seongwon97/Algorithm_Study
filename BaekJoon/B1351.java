package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1351
// 무한 수열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        Map<Long, Long> dp = new HashMap<>();
        dp.put(0L, 1L);

        System.out.println(findDp(dp, N, P, Q));
    }

    private static long findDp(Map<Long, Long> dp, long n, int P, int Q) {
        if (!dp.containsKey(n)) {
            dp.put(n, findDp(dp, n / P, P, Q) + findDp(dp, n / Q, P, Q));
        }
        return dp.get(n);
    }
}
/*
Input
7 2 3

Output
7
---
Input
7 2 3

Output
1
---
Input
10000000 3 3

Output
32768
*/
