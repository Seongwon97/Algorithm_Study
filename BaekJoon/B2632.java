package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 피자판매
// https://www.acmicpc.net/problem/2632
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int order = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numOfA = Integer.parseInt(st.nextToken());
		int numOfB = Integer.parseInt(st.nextToken());
		int[] pizzaA = new int[numOfA];
		int[] pizzaB = new int[numOfB];
		int[] cumulativeSumA = new int[numOfA * 2 - 1];
		int[] cumulativeSumB = new int[numOfB * 2 - 1];
		int[] dpA = new int[order + 1];
		int[] dpB = new int[order + 1];
		dpA[0] = 1;
		dpB[0] = 1;

		for (int i = 0; i < numOfA; i++) {
			pizzaA[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < numOfB; i++) {
			pizzaB[i] = Integer.parseInt(br.readLine());
		}

		calculateCumulativeSum(cumulativeSumA, numOfA, pizzaA);
		calculateCumulativeSum(cumulativeSumB, numOfB, pizzaB);

		findAllCases(dpA, cumulativeSumA, pizzaA, numOfA, order);
		findAllCases(dpB, cumulativeSumB, pizzaB, numOfB, order);

		int answer = 0;
		for (int i = 0; i <= order; i++) {
			answer += (dpA[i] * dpB[order - i]);
		}

		System.out.println(answer);
	}

	private static void findAllCases(int[] dp, int[] cumulativeSum, int[] pizza, int numOfPieces, int order) {
		if (cumulativeSum[numOfPieces] <= order) {
			dp[cumulativeSum[numOfPieces]]++;
		}

		for (int i = numOfPieces - 1; i < cumulativeSum.length; i++) {
			for (int j = 1; j < numOfPieces; j++) {
				int num = cumulativeSum[i] - cumulativeSum[i - j];
				if (num <= order) {
					dp[num]++;
				}
			}
		}
	}

	private static void calculateCumulativeSum(int[] cumulativeSum, int numOfPiece, int[] pizza) {
		for (int i = 1; i < cumulativeSum.length; i++) {
			int pizzaIdx = i;
			if (pizzaIdx > numOfPiece) {
				pizzaIdx -= numOfPiece;
			}
			pizzaIdx--;

			cumulativeSum[i] = cumulativeSum[i - 1] + pizza[pizzaIdx];
		}
	}
}
/*
Input
7
5 3
2
2
1
7
2
6
8
3

Output
5
*/
