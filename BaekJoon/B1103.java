package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 게임
// https://www.acmicpc.net/problem/1103
public class Main {
	private static int answer = 0;
	private static int N, M;
	private static char[][] matrix;
	private static boolean hasCycle = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		matrix = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				matrix[i][j] = line.charAt(j);
			}
		}

		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		int[][] dp = new int[N][M];
		dfs(0, 0, visited, dp, 1);

		if (hasCycle) {
			answer = -1;
		}

		System.out.println(answer);
	}

	private static void dfs(int x, int y, boolean[][] visited, int[][] dp, int count) {
		dp[x][y] = count;
		answer = Math.max(answer, count);

		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i] * (matrix[x][y] - '0');
			int ny = y + dy[i] * (matrix[x][y] - '0');

			if (nx < 0 || nx >= N || ny < 0 || ny >= M || matrix[nx][ny] == 'H' || count < dp[nx][ny]) {
				continue;
			}

			if (visited[nx][ny]) {
				hasCycle = true;
				return;
			}

			visited[nx][ny] = true;
			dfs(nx, ny, visited, dp, count + 1);
			visited[nx][ny] = false;
		}
	}
}
/*
Input
5 7
3994995
9999999
4H99399
9999999
2993994

Output
6
======
Input
4 4
3HH2
H1HH
H2H1
2219

Output
8
*/
