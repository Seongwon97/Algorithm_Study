import java.util.*;

class Solution {
    static List<Integer> createdNumbers = new ArrayList<>();
    static boolean[] visited = new boolean[7];

    public int solution(String numbers) {
        int answer = 0;
        for (int i = 0; i < numbers.length(); i++) {
            dfs(numbers, new StringBuilder(), i + 1);
        }

        for (int number : createdNumbers) {
            if (isPrime(number)) {
                answer++;
            }
        }
        return answer;
    }

    private void dfs(String numbers, StringBuilder number, int m) {
        if (number.length() == m) {
            int num = Integer.parseInt(number.toString());
            if (!createdNumbers.contains(num)) {
                createdNumbers.add(num);
            }
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                number.append(numbers.charAt(i));
                dfs(numbers, number, m);
                visited[i] = false;
                number.deleteCharAt(number.length() - 1);
            }
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
