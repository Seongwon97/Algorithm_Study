package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2133
// 타일 채우기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N % 2 != 0) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[N + 1];
        dp[2] = 3;
        int cached = 2;
        for (int i = 4; i <= N; i += 2) {
            // 4,6,8...별로 특별하게 만들 수 있는 case가 2개씩 있다
            // cached 변수는 i-n개로부터 n개의 블럭으로 만드는 특별한 case를 바로 붙여서 새로운 블록을 만드는 경우의 수를 구하기 위해 dp[i-2] + dp[i-4]...를 저장한 변수이다.
            dp[i] = dp[i - 2] * dp[2] + cached;
            cached += (dp[i - 2] * 2);
        }

        System.out.println(dp[N]);
    }
}
/*
Input
2

Output
3
*/
