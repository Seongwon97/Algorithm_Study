package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 럭키 스트레이크 (구현)
public class Ch12_implementation_Q07 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String N = st.nextToken();
            int nLength = N.length();

            String front = N.substring(0, nLength / 2);
            String second = N.substring(nLength / 2);

            int sumOfFront = findSum(front);
            int sumOfSecond = findSum(second);

            if (sumOfFront == sumOfSecond) {
                System.out.println("LUCKY");
            } else {
                System.out.println("READY");
            }

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
123402

Output
LUCKY
---
Input
7755

Outputr
READY
 */
