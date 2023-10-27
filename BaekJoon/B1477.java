package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// 휴게소 세우기
// https://www.acmicpc.net/problem/1477
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] restArea = new int[N + 2];
		for (int i = 1; i <= N; i++) {
			restArea[i] = Integer.parseInt(st.nextToken());
		}

		restArea[0] = 0;
		restArea[N + 1] = L;
		Arrays.sort(restArea);

		int left = 1;
		int right = L - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			int count = 0;
			for (int i = 1; i < restArea.length; i++) {
				int numOfNewRestArea = (restArea[i] - restArea[i - 1] - 1) / mid;
				count += numOfNewRestArea;
			}

			if (count > M) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(left);
	}
}
/*
Input
6 7 800
622 411 201 555 755 82

Output
70
*/
