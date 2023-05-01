package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/13144
// List of Unique Numbers
public class Main {
    static boolean answer = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1 ≤ N ≤ 100,000
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        // 값, index를 저장
        Set<Integer> sequence = new HashSet<>();
        sequence.add(nums[0]);
        int firstIndex = 0;

        for (int i = 1; i < N; i++) {
            if (sequence.contains(nums[i])) {
                while (nums[firstIndex] != nums[i]) {
                    dp[firstIndex] = sequence.size();
                    sequence.remove(nums[firstIndex]);
                    firstIndex++;
                }
                dp[firstIndex] = sequence.size();
                sequence.remove(nums[firstIndex]);
                firstIndex++;
            }

            sequence.add(nums[i]);
        }

        // 이후의 dp값 채우기
        for (int i = firstIndex; i < N; i++) {
            dp[i] = sequence.size();
            sequence.remove(nums[i]);
        }

        long answer = 0;
        for (int i : dp) {
            answer += i;
        }

        System.out.println(answer);
    }
}
/*
Input
5
1 2 3 4 5

Output
15
---
Input
5
1 2 3 1 2

Output
12
---
Input
5
1 1 1 1 1

Output
5
*/
