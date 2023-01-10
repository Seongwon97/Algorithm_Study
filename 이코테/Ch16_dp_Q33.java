package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 퇴사
// https://www.acmicpc.net/problem/14501
public class Ch16_dp_Q33 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int[] times = new int[N];
            int[] profits = new int[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                times[i] = Integer.parseInt(st.nextToken());
                profits[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[N + 1];
            int maxValue = 0;
            for (int i = N - 1; i >= 0; i--) {
                int time = times[i] + i;
                if (time <= N) {
                    dp[i] = Math.max(profits[i] + dp[time], maxValue);
                    maxValue = dp[i];
                } else {
                    dp[i] = maxValue;
                }
            }

            System.out.println(maxValue);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
Input
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200

Output
45
---
Input
10
1 1
1 2
1 3
1 4
1 5
1 6
1 7
1 8
1 9
1 10

Output
55
---
Input
10
5 10
5 9
5 8
5 7
5 6
5 10
5 9
5 8
5 7
5 6

Output
20
---
Input
10
5 50
4 40
3 30
2 20
1 10
1 10
2 20
3 30
4 40
5 50

Output
90
 */
