package chapter3_greedy;

// 개미 전사
public class Ch8_dp_ex2 {

    public static void main(String[] args) {
        int[] input = {1, 3, 1, 5};
        System.out.println(solution(input));
    }

    private static int solution(int[] input) {
        int[] dp = new int[input.length];
        dp[0] = input[0];
        dp[1] = Math.max(input[0], input[1]);

        for (int i = 2; i < input.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + input[i]);
        }

        return dp[input.length - 1];
    }
}
