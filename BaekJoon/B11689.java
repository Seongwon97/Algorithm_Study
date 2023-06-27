package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11689
// GCD(n, k) = 1
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        System.out.println(eulerPhi(N));
    }

    private static long eulerPhi(long n) {
        long pi = n;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                pi = pi / i * (i - 1);
            }
            while (n % i == 0) {
                n /= i;
            }
        }

        if (n != 1) {
            pi = pi / n * (n - 1);
        }

        return pi;
    }
}
/*
Input
27123

Output
6
*/
