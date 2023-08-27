package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 역사
// https://www.acmicpc.net/problem/1613
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] matrix = new int[n + 1][n + 1];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int previous = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			matrix[previous][next] = -1;
			matrix[next][previous] = 1;
		}

		for (int m = 1; m <= n; m++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (matrix[i][m] == -1 && matrix[m][j] == -1) {
						matrix[i][j] = -1;
						matrix[j][i] = 1;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int s = Integer.parseInt(br.readLine());
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			int previous = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());

			sb.append(matrix[previous][next])
				.append("\n");
		}

		System.out.println(sb);
	}
}
/*
Input
5 5
1 2
1 3
2 3
3 4
2 4
3
1 5
2 4
3 1

Output
0
-1
1
*/
