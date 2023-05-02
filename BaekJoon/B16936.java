package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16936
// 나3곱2
public class Main {
    //
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] arr = new long[N][2]; // 0번 인덱스는 숫자, 1번은 3으로 나눠지는 횟수
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long number = Long.parseLong(st.nextToken());
            arr[i][0] = number;

            while (number % 3 == 0) {
                arr[i][1] += 1;
                number /= 3;
            }
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) { // 3으로 나눠지는 횟수가 같다면 오름차순 정렬
                return Long.compare(o1[0], o2[0]);
            }
            // 나눠지는 횟수가 다르면 나눠지는 횟수가 많은게 앞으로!
            return Long.compare(o2[1], o1[1]);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i][0]).append(" ");
        }
        System.out.println(sb);
    }
}
/*
Input
6
4 8 6 3 12 9

Output
9 3 6 12 4 8
---
Input
4
42 28 84 126

Output
126 42 84 28
*/
