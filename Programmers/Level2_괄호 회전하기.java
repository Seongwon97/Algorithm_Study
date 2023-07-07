import java.util.Stack;

//https://school.programmers.co.kr/learn/courses/30/lessons/76502
class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            s = rotate(s);
            if (isRightStr(s)) {
                answer++;
            }
        }
        return answer;
    }

    private String rotate(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(1, s.length()));
        sb.append(s.charAt(0));
        return sb.toString();
    }

    private boolean isRightStr(String s) {
        if (s.length() % 2 != 0) { // 문자열이 홀수 개수일 경우는 무조건 대칭 실패
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) { // stack이 비어있다는건 닫혀있는 문자열이 먼저 나온다는 뜻
                return false;
            }

            if (c == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }  else if (c == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }  else if (c == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
