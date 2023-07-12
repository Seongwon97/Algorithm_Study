package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/9935
// 문자열 폭발
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char c : str) {
            stack.push(c);
            if (stack.size() >= bomb.length && stack.peek() == bomb[bomb.length - 1]) {
                int lastIdx = stack.size() - 1;
                boolean canExplode = true;
                for (int j = 0; j < bomb.length; j++) {
                    if (stack.elementAt(lastIdx - j) != bomb[bomb.length - 1 - j]) {
                        canExplode = false;
                        break;
                    }
                }

                if (canExplode) {
                    for (int j = 0; j < bomb.length; j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            sb.append("FRULA");
        } else {
            for (int i = 0; i < stack.size(); i++) {
                sb.append(stack.elementAt(i));
            }
        }

        System.out.println(sb);
    }
}
/*
Input
4
1 3
4 3
4 2
1 2

Output
0 0 0 0
---
Input
6
1 2
3 4
6 4
2 3
1 3
3 5

Output
0 0 0 1 1 2
*/
