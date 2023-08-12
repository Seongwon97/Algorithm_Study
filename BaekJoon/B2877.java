package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2877
// 4와 7
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int num = K + 1;
        while (num != 0) {
            sb.append(num % 2);
            num /= 2;
        }

        StringBuilder result = new StringBuilder();
        for (int i = sb.length() - 2; i >= 0; i--) {
            if (sb.charAt(i) == '0') {
                result.append(4);
            } else {
                result.append(7);
            }
        }

        System.out.println(result);
    }
}
/*
Input
1

Output
4
------
Input
2

Output
7
*/
