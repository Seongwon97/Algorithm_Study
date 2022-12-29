package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 볼링공 고르기 (Greedy)
public class Ch11_greedy_Q05 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] balls = new int[M + 1];
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                balls[num]++;
            }

            Arrays.sort(balls);

            int count = 0;
            for (int i = 1; i < balls.length; i++) {
                N -= balls[i];
                count += (balls[i] * N);
            }

            System.out.println(count);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
/*
Input
5 3
1 3 2 3 2

Output
8
---
Input
8 5
1 5 4 3 2 4 5 2

Outputr
25
 */
