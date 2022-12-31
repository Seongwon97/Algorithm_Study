package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 문자열 재정렬 (구현)
public class Ch12_implementation_Q08 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();

            List<Character> chars = new ArrayList<>();
            List<Integer> ints = new ArrayList<>();

            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);

                if ('0' <= c && c <= '9') {
                    ints.add(Integer.parseInt(String.valueOf(c)));
                } else {
                    chars.add(c);
                }
            }

            Collections.sort(chars);
            int sum = 0;
            for (Integer i : ints) {
                sum += i;
            }

            StringBuilder sb = new StringBuilder();
            for (Character c : chars) {
                sb.append(c);
            }
            sb.append(sum);

            System.out.println(sb);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int findSum(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return sum;
    }
}
/*
Input
K1KA5CB7

Output
ABCKK13
---
Input
AJKDLSI412K4JSJ9D

Output
ADDIJJJKKLSS20
 */
