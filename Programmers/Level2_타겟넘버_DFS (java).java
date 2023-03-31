import java.util.*;

class Solution {
    static int count = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);

        return count;
    }

    public static void dfs(int[] numbers, int currentRow, int sum, int target) {
        if (currentRow == numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                sum += numbers[currentRow];
                dfs(numbers, currentRow + 1, sum, target);
                sum -= numbers[currentRow];
            } else {
                sum -= numbers[currentRow];
                dfs(numbers, currentRow + 1, sum, target);
                sum += numbers[currentRow];
            }
        }
    }
}
