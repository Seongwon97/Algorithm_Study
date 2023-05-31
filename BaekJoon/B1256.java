package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1256
// 사전
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        double[][] dp = new double[101][101];

        StringBuilder result = new StringBuilder();
        if (calculateNumOfChild(dp, N, M) < K) {
            System.out.println(-1);
        } else {
            findString(result, dp, N, M, K);
            System.out.println(result);
        }
    }

    private static void findString(StringBuilder result, double[][] dp, int numOfA, int numOfZ, double K) {
        if (numOfA == 0) {
            for (int i = 0; i < numOfZ; i++) {
                result.append("z");
            }
            return;
        }
        if (numOfZ == 0) {
            for (int i = 0; i < numOfA; i++) {
                result.append("a");
            }
            return;
        }

        double numOfChild = calculateNumOfChild(dp, numOfA - 1, numOfZ);

        if (K > numOfChild) {
            result.append("z");
            findString(result, dp, numOfA, numOfZ - 1, K - numOfChild);
        } else {
            result.append("a");
            findString(result, dp, numOfA - 1, numOfZ, K);
        }
    }

    private static double calculateNumOfChild(double[][] dp, int numOfA, int numOfZ) {
        if (numOfA == 0 || numOfZ == 0) {
            return 1;
        }
        if (dp[numOfA][numOfZ] != 0) {
            return dp[numOfA][numOfZ];
        }

        return dp[numOfA][numOfZ] = Double.min(
                calculateNumOfChild(dp, numOfA - 1, numOfZ) + calculateNumOfChild(dp, numOfA, numOfZ - 1), 1000000001);
    }
}
/*
Input
2 2 2

Output
azaz
---
Input
2 2 6

Output
zzaa
---
Input
10 10 1000000000

Output
-1
*/
