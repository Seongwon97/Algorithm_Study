package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 큰 수의 법칙
public class Ch3_greedy_ex2_Improve {

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
        int count = m / (k + 1) * k;
        count += m & (k + 1);

        int answer = 0;
        answer += count * firstNumber;
        answer += (m - count) * secondNumber;

        System.out.println(answer);
    }
}
