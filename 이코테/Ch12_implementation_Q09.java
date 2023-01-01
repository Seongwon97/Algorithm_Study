package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문자열 압축 (구현)
public class Ch12_implementation_Q09 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();

            System.out.println(solution(S));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int solution(String s) {
        int answer = Integer.MAX_VALUE;

        if (s.length() == 1) {
            answer = 1;
        }

        for (int l = 1; l <= s.length() / 2; l++) {

            StringBuilder sb = new StringBuilder();
            int count = 1;

            String previous = s.substring(0, l);
            int i;
            for (i = l; i <= s.length() - l; i += l) {
                String current = s.substring(i, i + l);
                // 이전 문자와 같을 경우
                if (previous.equals(current)) {
                    count++;
                }
                // 이전 문자와 다를 경우
                else {
                    if (count != 1) {
                        sb.append(count);
                    }
                    sb.append(previous);
                    previous = current;
                    count = 1;
                }

                // 마지막 문자일 경우
                if (i > (s.length() - (l * 2))) {
                    if (count != 1) {
                        sb.append(count);
                    }
                    sb.append(previous);
                    sb.append(s.substring(i + l));
                }
            }
            if (answer > sb.length()) {
                answer = sb.length();
            }
        }

        return answer;
    }
}
/*
입력값 〉	"aabbaccc"
기댓값 〉	7
---
입력값 〉	"ababcdcdababcdcd"
기댓값 〉	9
---
입력값 〉	"abcabcdede"
기댓값 〉	8
---
입력값 〉	"abcabcabcabcdededededede"
기댓값 〉	14
---
 */
