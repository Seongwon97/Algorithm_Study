import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 큰 정사각형
// https://www.acmicpc.net/problem/1915
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] matrix = new char[n][m];
        int[][] dp = new int[n][m];
        int maxNum = 0;
        for (int i = 0; i < n; i++) {
            matrix[i] = reader.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                dp[i][j] = matrix[i][j] - '0';
                if (dp[i][j] == 1 && maxNum == 0) {
                    maxNum = 1;
                }
                if (j > 0 && i > 0) {
                    if (dp[i - 1][j] > 0 && dp[i][j - 1] > 0 && dp[i - 1][j - 1] > 0 && dp[i][j] == 1) {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                        maxNum = Math.max(dp[i][j], maxNum);
                    }
                }
            }
        }
        System.out.println(maxNum * maxNum);
    }
}
/*
Input
4 4
0100
0111
1110
0010

Output
4
*/
