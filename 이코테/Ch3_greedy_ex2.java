package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ch3_greedy_ex2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        int firstNumber = numbers[n - 1];
        int secondNumber = numbers[n - 2];
        int answer = 0;

        while(m > 0) {
            for (int i = 0; i < k; i++) {
                answer += firstNumber;
                m--;
            }
            if (m > 0) {
                answer += secondNumber;
                m--;
            }
        }

        System.out.println(answer);
    }
}
