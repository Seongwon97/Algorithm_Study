import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && c == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            stack.push(c);
        }

        return stack.isEmpty();
    }
}
