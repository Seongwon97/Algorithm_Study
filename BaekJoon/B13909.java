package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/13909
// 창문 닫기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 1; i * i <= n; i++) {
            cnt++;
        }

        System.out.println(cnt);
    }
}
/*
Input
24

Output
4
*/
