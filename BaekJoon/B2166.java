package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다각형의 면적
// https://www.acmicpc.net/problem/2166
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] points = new long[N + 1][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}
		points[N][0] = points[0][0];
		points[N][1] = points[0][1];

		long sum1 = 0;
		long sum2 = 0;
		for (int i = 0; i < N; i++) {
			sum1 += (points[i][0] * points[i + 1][1]);
			sum2 += (points[i][1] * points[i + 1][0]);
		}

		String area = String.format("%.1f", Math.abs(sum1 - sum2) / 2.0);

		System.out.println(area);
	}
}
/*
Input
4
0 0
0 10
10 10
10 0

Output
100.0
*/
