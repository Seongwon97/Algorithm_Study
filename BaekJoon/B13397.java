package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/13397
// 구간 나누기 2
public class Main {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int right = Integer.MIN_VALUE;
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            right = Math.max(numbers[i], right);

        }

        int left = 0;

        while (left < right) { // left, right는 구간별 최대-최소 값의 최대 크기
            int mid = (left + right) / 2;
            if (calculateNumOfBlock(N, numbers, mid) <= M) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);
    }

    private static int calculateNumOfBlock(int N, int[] numbers, int mid) {
        int count = 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            min = Math.min(min, numbers[i]);
            max = Math.max(max, numbers[i]);
            if (max - min > mid) {
                count++;
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                i--;
            }
        }
        return count;
    }
}
/*
Input
8 3
1 5 4 6 2 1 3 7

Output
5
---
Input
4 2
1 1 1 1

Output
0
---
Input
7 4
1 2 3 1 2 3 1

Output
2
---
Input
5 1
1 100 99 2 3

Output
99
*/
