package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 안테나
// https://www.acmicpc.net/problem/18310
public class B18310 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int[] houses = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                houses[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(houses);
            int mid = (N - 1) / 2;
            System.out.println(houses[mid]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
Input
4
5 1 7 9

Output
5
 */
