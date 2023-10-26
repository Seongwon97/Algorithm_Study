package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 전구와 스위치
// https://www.acmicpc.net/problem/2138
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str1 = br.readLine();
		String str2 = br.readLine();
		boolean[] start = new boolean[N];
		boolean[] target = new boolean[N];

		boolean[] nowA = new boolean[N]; // 1번 스위치 on
		boolean[] nowB = new boolean[N]; // 1번 스위치 off
		int caseA = 1;
		int caseB = 0;

		for (int i = 0; i < N; i++) {
			start[i] = str1.charAt(i) == '1';
			target[i] = str2.charAt(i) == '1';
		}

		for (int i = 0; i < N; i++) {
			if (i <= 1) {
				nowA[i] = !start[i];
			} else {
				nowA[i] = start[i];
			}
			nowB[i] = start[i];
		}

		for (int i = 1; i < N; i++) {
			if (nowA[i - 1] != target[i - 1]) {
				switchOn(i, N, nowA);
				caseA++;
			}
			if (nowB[i - 1] != target[i - 1]) {
				switchOn(i, N, nowB);
				caseB++;
			}
		}

		int answer = Integer.MAX_VALUE;
		if (Arrays.equals(nowA, target)) {
			answer = Math.min(answer, caseA);
		}

		if (Arrays.equals(nowB, target)) {
			answer = Math.min(answer, caseB);
		}

		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	private static void switchOn(int i, int N, boolean[] switches) {
		switches[i - 1] = !switches[i - 1];
		switches[i] = !switches[i];

		if (i < N - 1) {
			switches[i + 1] = !switches[i + 1];
		}
	}
}
/*
Input
3 6
1 1 1 2
2 1 2 2
1 1 1 3
2 3 3 1
1 3 1 2
1 3 2 1

Output
5
*/
