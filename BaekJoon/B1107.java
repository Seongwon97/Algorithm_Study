package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1107
// 리모컨
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        int N = Integer.parseInt(number);
        int M = Integer.parseInt(br.readLine());
        boolean[] isNotWorking = new boolean[10];
        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int button = Integer.parseInt(st.nextToken());
                isNotWorking[button] = true;
            }
        }

        int answer = Math.abs(100 - N);
        for (int i = 0; i <= 999_999; i++) {
            String num = String.valueOf(i);

            boolean isAvailable = true;
            for (int j = 0; j < num.length(); j++) {
                if (isNotWorking[num.charAt(j) - '0']) {
                    isAvailable = false;
                    break;
                }
            }
            if (isAvailable) {
                answer = Math.min(answer, Math.abs(N - i) + num.length());
            }
        }
        System.out.println(answer);
    }
}
/*
Input
5457
3
6 7 8

Output
6
---
Input
100
5
0 1 2 3 4

Output
0
*/
