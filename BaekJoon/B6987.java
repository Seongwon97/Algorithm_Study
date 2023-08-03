package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/6987
// 월드컵
public class Main {
    private static int[] team1 = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
    private static int[] team2 = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
    private static int[] answer = new int[4];
    private static int[][] match = new int[6][3];
    private static int[][] result = new int[6][3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 총 15경기 (N * (N - 1) / 2)
        // 각각 가능한 경우의 수 3가지 -> 3^15
        for (int tc = 0; tc < 4; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 3; k++) {
                    match[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(tc, 0);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(answer[i])
                    .append(" ");
        }
        System.out.println(sb);
    }

    private static void dfs(int tc, int round) {
        if (round == 15) { // 15개 경기 종료
            if (answer[tc] == 1) { // 이미 판단이 완료된 경우
                return;
            }

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    // 예측 값이랑 맞지 않는 경우
                    if (match[i][j] != result[i][j]) {
                        return;
                    }
                }
            }
            answer[tc] = 1;
            return;
        }

        int t1 = team1[round];
        int t2 = team2[round];

        // t1 승, t2 패
        result[t1][0]++;
        result[t2][2]++;
        dfs(tc, round + 1);
        result[t1][0]--;
        result[t2][2]--;

        // t1 무, t2 무
        result[t1][1]++;
        result[t2][1]++;
        dfs(tc, round + 1);
        result[t1][1]--;
        result[t2][1]--;

        // t1 패, t2 승
        result[t1][2]++;
        result[t2][0]++;
        dfs(tc, round + 1);
        result[t1][2]--;
        result[t2][0]--;
    }
}
/*
Input
5 0 0 3 0 2 2 0 3 0 0 5 4 0 1 1 0 4
4 1 0 3 0 2 4 1 0 1 1 3 0 0 5 1 1 3
5 0 0 4 0 1 2 2 1 2 0 3 1 0 4 0 0 5
5 0 0 3 1 1 2 1 2 2 0 3 0 0 5 1 0 4

Output
1 1 0 0
*/
