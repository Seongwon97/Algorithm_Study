package chapter3_greedy;

// 1로 만들기
public class Ch8_dp_ex1 {

    public static void main(String[] args) {
        int input = 26;
        System.out.println(solution(input));
    }

    private static int solution(int input) {
        int[] dp = new int[input + 1];

        for (int i = 2; i < input + 1; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
            if (i % 5 == 0) {
                dp[i] = Math.min(dp[i], dp[i/5] + 1);
            }
        }

        return dp[input];
    }
}
