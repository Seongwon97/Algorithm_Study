package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 어려운 소인수분해
// https://www.acmicpc.net/problem/16563
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] numbers = new int[N];
		int maxNumber = 0;
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());

			if (maxNumber < numbers[i]) {
				maxNumber = numbers[i];
			}
		}

		int[] minFactor = new int[maxNumber + 1];
		for (int i = 2; i <= maxNumber; i++) {
			minFactor[i] = i;
		}

		for (int i = 2; i * i <= maxNumber; i++) {
			if (minFactor[i] == i) {
				for (int j = i * 2; j <= maxNumber; j += i) {
					if (minFactor[j] == j) {
						minFactor[j] = i;
					}
				}
			}
		}

		StringBuilder result = new StringBuilder();
		for (int number : numbers) {
			while (number > 1) {
				result.append(minFactor[number]).append(" ");
				number /= minFactor[number];
			}
			result.append("\n");
		}

		System.out.print(result);
	}
}
/*
Input
5
5 4 45 64 54

Output
5
2 2
3 3 5
2 2 2 2 2 2
2 3 3 3
*/
