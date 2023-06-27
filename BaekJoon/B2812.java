package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2812
// 크게 만들기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String number = br.readLine();

        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        while (K >= 0 && idx < N) {
            char c = number.charAt(idx++);
            int currentNumber = c - '0';
            if (stack.isEmpty()) { // 비어있을 경우
                stack.push(currentNumber);
            } else if (stack.peek() >= currentNumber) { // 다음 숫자가 더 클 경우
                stack.push(currentNumber);
            } else { // 다음 숫자가 더 작아질 경우
                while (K > 0 && !stack.isEmpty() && stack.peek() < currentNumber) {
                    stack.pop();
                    K--;
                }

                stack.push(currentNumber);
            }
        }

        while (K > 0) {
            stack.pop();
            K--;
        }

        StringBuilder result = new StringBuilder();
        for (Integer n : stack) {
            result.append(n);
        }

        System.out.println(result);
    }
}
/*
Input
4 2
1924

Output
94
---
Input
7 3
1231234

Output
3234
---
Input
10 4
4177252841

Output
775841
*/
