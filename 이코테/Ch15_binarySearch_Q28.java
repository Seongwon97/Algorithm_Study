package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 고정점 찾기
public class Ch15_binarySearch_Q28 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int[] numbers = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            int answer = -1;
            int start = 0;
            int end = N - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (mid == numbers[mid]) {
                    answer = mid;
                    break;
                }
                if (mid < numbers[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
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
5
-15 -6 1 3 7

Output
3
---
Input
7
-15 -4 2 8 9 13 15

Output
2
---
Input
7
-15 -4 3 8 9 13 15

Output
-1
 */
