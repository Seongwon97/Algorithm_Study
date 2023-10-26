package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 집합의 표현
// https://www.acmicpc.net/problem/1717
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] parents = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (command == 0) {
				unionParent(parents, a, b);
			} else {
				if (findParent(parents, a) == findParent(parents, b)) {
					sb.append("YES");
				} else {
					sb.append("NO");
				}
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}

	private static int findParent(int[] parents, int n) {
		if (parents[n] != n) {
			parents[n] = findParent(parents, parents[n]);
		}
		return parents[n];
	}

	private static void unionParent(int[] parents, int n1, int n2) {
		int parent1 = findParent(parents, n1);
		int parent2 = findParent(parents, n2);

		if (parent1 < parent2) {
			parents[parent2] = parent1;
		} else {
			parents[parent1] = parent2;
		}
	}
}
/*
Input
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1

Output
NO
NO
YES
*/
