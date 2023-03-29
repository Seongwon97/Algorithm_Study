import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> answers = new Stack<>();
        for (int i : arr) {
            if (answers.isEmpty() || answers.peek() != i) {
                answers.push(i);
            }
        }

        return answers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
