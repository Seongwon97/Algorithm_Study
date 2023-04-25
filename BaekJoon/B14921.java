package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14921
// 용액 합성하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long min = 200_000_001;
        int start = 0;
        int end = N - 1;
        while (start < end) {
            long sum = arr[start] + arr[end];

            if (sum < 0) {
                start++;
            } else {
                end--;
            }

            if (Math.abs(sum) < Math.abs(min)) {
                min = sum;
            }
        }

        System.out.println(min);
    }
}
/*
Input
5
-101 -3 -1 5 93

Output
2
---
Input
2
-100000 -99999

Output
-199999
---
Input
7
-698 -332 -123 54 531 535 699

Output
1
*/

