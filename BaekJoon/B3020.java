package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3020
// 개똥벌레
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        // 구간 -> 0~1이면 구간 1
        int[] top = new int[H + 2];
        int[] bottom = new int[H + 2];
        for (int i = 0; i < N / 2; i++) {
            bottom[Integer.parseInt(br.readLine())]++;
            top[H - Integer.parseInt(br.readLine()) + 1]++;
        }

        for (int i = 1; i <= H; i++) {
            top[i] += top[i - 1];
        }

        for (int i = H; i > 0; i--) {
            bottom[i] += bottom[i + 1];
        }

        int min = Integer.MAX_VALUE;
        int minCount = 0;
        for (int i = 1; i <= H; i++) {
            int numOfObstacle = top[i] + bottom[i];
            if (numOfObstacle < min) {
                min = numOfObstacle;
                minCount = 1;
            } else if (numOfObstacle == min) {
                minCount++;
            }
        }

        System.out.println(min + " " + minCount);
    }
}
/*
Input
6 7
1
5
3
3
5
1

Output
2 3
---
Input
14 5
1
3
4
2
2
4
3
4
3
3
3
2
3
3

Output
7 2
*/
