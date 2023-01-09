package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 공유기 설치
// https://www.acmicpc.net/problem/2110
public class Ch15_binarySearch_Q29 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int[] positions = new int[N];
            for (int i = 0; i < N; i++) {
                positions[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(positions);

            int answer = 0;
            int startGap = 1;
            int endGap = positions[N - 1] - positions[0];

            while (startGap <= endGap) {
                int midGap = (startGap + endGap) / 2;
                int currentPoint = positions[0];
                int count = 1;

                for (int i = 1; i < N; i++) {
                    if (positions[i] >= currentPoint + midGap) {
                        currentPoint = positions[i];
                        count++;
                    }
                }

                if (count >= C) {
                    startGap = midGap + 1;
                    answer = midGap;
                } else {
                    endGap = midGap - 1;
                }
            }

            System.out.println(answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
Input
5 3
1
2
8
4
9

Output
3
 */
