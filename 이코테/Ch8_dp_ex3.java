package chapter3_greedy;

// 바닥 공사
public class Ch8_dp_ex3 {

    public static void main(String[] args) {
        int input = 3;
        System.out.println(solution(input));
    }

    private static int solution(int input) {
        int[] dp = new int[input + 1];
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i < input + 1; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 796796;
        }

        return dp[input];
    }
}
