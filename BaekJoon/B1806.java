package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1806
// 부분합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        long[] cumulativeSum = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            cumulativeSum[i] = cumulativeSum[i - 1] + numbers[i];
        }

        int answer = Integer.MAX_VALUE;
        int start = 1;
        int end = 1;
        while (start <= N && end <= N) {
            long sum = cumulativeSum[end] - cumulativeSum[start - 1];
            if (sum >= S) {
                answer = Math.min(answer, end - start + 1);
                start++;
            } else {
                end++;
            }
        }

        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }

        System.out.println(answer);
    }
}
/*
Input
ACAYKP
CAPCAK

Output
4
ACAK
*/
