package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1756
// 피자 굽기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] ovens = new int[D + 1];
        ovens[0] = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= D; i++) {
            ovens[i] = Integer.parseInt(st.nextToken());
            ovens[i] = Math.min(ovens[i - 1], ovens[i]);
        }

        int[] pizzas = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pizzas[i] = Integer.parseInt(st.nextToken());
        }

        int bottom = D;
        for (int i = 0; i < N; i++) {
            while (bottom >= 0 && pizzas[i] > ovens[bottom--]);
        }

        System.out.println(bottom + 1);
    }
}
/*
Input
7 3
5 6 4 3 6 2 3
3 2 5

Output
2
*/
