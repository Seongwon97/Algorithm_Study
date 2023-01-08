package chapter3_greedy;

// 괄호 변환
// https://school.programmers.co.kr/learn/courses/30/lessons/60058
public class Ch13_dfs_bfs_Q18 {

    public static void main(String[] args) {
        String str = "(()())()";
        System.out.println(solution(str));
    }

    public static String solution(String p) {
        return findSolution(p);
    }

    public static String findSolution(String p) {
        if (p.length() == 0) { // 1
            return "";
        }

        int balancedStringEndIndex = getBalancedStringEndIndex(p); // 2
        String u = p.substring(0, balancedStringEndIndex);
        String v = p.substring(balancedStringEndIndex);

        if (isCorrectString(u)) { // 3
            String func = findSolution(v);
            return u + func;
        }

        StringBuilder sb = new StringBuilder("("); // 4-1
        sb.append(findSolution(v)); // 4-2
        sb.append(")"); // 4-3
        for (int i = 1; i < u.length() - 1; i++) { // 4-4
            if (u.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }

        return sb.toString(); // 4-5
    }

    private static int getBalancedStringEndIndex(String p) {
        int openCount = 0;
        int closeCount = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                openCount++;
            } else if (p.charAt(i) == ')') {
                closeCount++;
            }

            if (openCount == closeCount) {
                return i + 1;
            }
        }
        return p.length() + 1;
    }

    private static boolean isCorrectString(String p) {
        int openCount = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                openCount++;
            } else if (p.charAt(i) == ')') {
                openCount--;
            }

            if (openCount < 0) {
                return false;
            }
        }
        return true;
    }
}

/*
입력값 〉	"(()())()"
기댓값 〉	"(()())()"
---
입력값 〉	")("
기댓값 〉	"()"
---
입력값 〉	"()))((()"
기댓값 〉	"()(())()"
 */
/*
1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
  4-3. ')'를 다시 붙입니다.
  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
  4-5. 생성된 문자열을 반환합니다.
 */
