package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 곱하기 혹은 더하기 (Greedy)
public class Ch11_greedy_Q02 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s = br.readLine();
            int result = Integer.parseInt(String.valueOf(s.charAt(0)));

            for (int i = 1; i < s.length(); i++) {
                int num = Integer.parseInt(String.valueOf(s.charAt(i)));
                if (result == 0 || result == 1 || num == 0 || num == 1) {
                    result += num;
                    continue;
                }
                result *= num;
            }

            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
/*
Input
02984

Output
576
---
Input
567

Output
210
 */
