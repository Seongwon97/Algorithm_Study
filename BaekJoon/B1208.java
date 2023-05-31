package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1208
// 부분수열의 합 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> leftSequence = new ArrayList<>();
        List<Integer> rightSequence = new ArrayList<>();

        getSequence(0, N / 2, 0, arr, leftSequence);
        getSequence(N / 2, N, 0, arr, rightSequence);

        Collections.sort(leftSequence);
        Collections.sort(rightSequence);

        System.out.println(findAnswer(leftSequence, rightSequence, S));
    }

    public static void getSequence(int start, int end, int sum, int[] arr, List<Integer> sequence) {
        if (start == end) {
            sequence.add(sum);
            return;
        }

        getSequence(start + 1, end, sum + arr[start], arr, sequence);
        getSequence(start + 1, end, sum, arr, sequence);
    }

    private static long findAnswer(List<Integer> leftSequence, List<Integer> rightSequence, int S) {
        int left = 0;
        int right = rightSequence.size() - 1;
        long answer = 0;

        while (left < leftSequence.size() && right >= 0) {
            int sum = leftSequence.get(left) + rightSequence.get(right);

            if (sum == S) {
                int currentA = leftSequence.get(left);
                long count1 = 0;
                while (left < leftSequence.size() && leftSequence.get(left) == currentA) {
                    left++;
                    count1++;
                }

                int currentB = rightSequence.get(right);
                long count2 = 0;
                while (right >= 0 && rightSequence.get(right) == currentB) {
                    right--;
                    count2++;
                }

                answer += count1 * count2;
            } else if (sum < S) {
                left++;
            } else {
                right--;
            }
        }

        if (S == 0) {
            return answer - 1;
        }
        return answer;
    }
}
/*
Input
5 0
-7 -3 -2 5 8

Output
1
---
Input
5 0
0 0 0 0 0

Output
31
*/
