import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int minNum = Integer.parseInt(st.nextToken());
        int maxNum = Integer.parseInt(st.nextToken());

        int[] dp = new int[maxNum + 1];
        for (int i = 2; i <= maxNum; i++) {
            if (dp[i] == 0) {
                dp[i]++;
            }
            for (int j = 2; j * i <= maxNum; j++) {
                dp[j * i] = dp[i] + dp[j];
            }
        }

        int result = 0;
        for (int i = minNum; i <= maxNum; i++) {
            if (dp[dp[i]] == 1) {
                result++;
            }
        }
        System.out.println(result);
    }
}
