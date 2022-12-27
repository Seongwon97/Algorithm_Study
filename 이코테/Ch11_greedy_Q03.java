package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자열 뒤집기 (Greedy)
public class Ch11_greedy_Q03 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s = br.readLine();

            char previousChar = ' ';
            int countZero = 0;
            int countOne = 0;
            for (int i = 0; i < s.length(); i++) {
                char presentChar = s.charAt(i);
                if (presentChar == previousChar) {
                    continue;
                }
                previousChar = presentChar;
                if (presentChar == '1') {
                    countOne++;
                    continue;
                }
                countZero++;
            }

            System.out.println(Math.min(countOne, countZero));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
/*
Input
0001100

Output
1
 */
