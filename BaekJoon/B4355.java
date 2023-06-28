package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/4355
// 서로소
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N != 0) {
            if (N == 1) {
                System.out.println(0);
            } else {
                System.out.println(eulerPhi(N));
            }
            N = Integer.parseInt(br.readLine());
        }
    }

    private static long eulerPhi(int n) {
        int result = n;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                result = result / i * (i - 1);
            }

            while (n % i == 0) {
                n /= i;
            }
        }

        if (n != 1) {
            result = result / n * (n - 1);
        }

        return result;
    }
}
/*
Input
7
12
0

Output
6
4
*/
