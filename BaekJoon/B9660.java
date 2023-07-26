package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/9660
// 돌 게임 6
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        if (N % 7 == 0 || N % 7 == 2) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}
/*
Input
6

Output
SK
*/
