package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2565
// 전깃줄
// 가장 긴 증가하는 수열!!!
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Connection> connections = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            connections.add(new Connection(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(connections);

        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (connections.get(j).end < connections.get(i).end && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(N - max);
    }

    static class Connection implements Comparable<Connection> {
        int start;
        int end;

        public Connection(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Connection o) {
            return this.start - o.start;
        }
    }
}
/*
Input
8
1 8
3 9
2 2
4 1
6 4
10 10
9 7
7 6

Output
3
*/
