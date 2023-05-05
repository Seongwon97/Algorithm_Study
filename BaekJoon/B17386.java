package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17386
// 선분 교차 1
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x1_1 = Long.parseLong(st.nextToken());
        long y1_1 = Long.parseLong(st.nextToken());
        long x2_1 = Long.parseLong(st.nextToken());
        long y2_1 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long x1_2 = Long.parseLong(st.nextToken());
        long y1_2 = Long.parseLong(st.nextToken());
        long x2_2 = Long.parseLong(st.nextToken());
        long y2_2 = Long.parseLong(st.nextToken());

        // CCW
        int result = 0;
        if (ccw(x1_1, y1_1, x2_1, y2_1, x1_2, y1_2) * ccw(x1_1, y1_1, x2_1, y2_1, x2_2, y2_2) < 0
                && ccw(x1_2, y1_2, x2_2, y2_2, x1_1, y1_1) * ccw(x1_2, y1_2, x2_2, y2_2, x2_1, y2_1) < 0) {
            result = 1;
        }

        System.out.println(result);
    }

    private static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        if (x1 * y2 + x2 * y3 + x3 * y1 - y1 * x2 - y2 * x3 - y3 * x1 < 0) {
            return 1;
        }
        return -1;
    }
}
/*
Input
1 1 5 5
1 5 5 1

Output
1
---
Input
1 1 5 5
6 10 10 6

Output
0
*/
