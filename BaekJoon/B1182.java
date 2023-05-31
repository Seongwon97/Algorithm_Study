package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1182
// 부분수열의 합
public class Main {

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < arr.length - 1; i++) {
            findAnswer(arr[i], arr, i, S);
        }

        System.out.println(answer);
    }

    private static void findAnswer(int sum, int[] arr, int lastIndex, int S) {
        if (sum == S) {
            answer++;
        }

        for (int i = lastIndex + 1; i < arr.length - 1; i++) {
            findAnswer(sum + arr[i], arr, i, S);
        }
    }
}
/*
Input
5 0
-7 -3 -2 5 8

Output
1
*/
