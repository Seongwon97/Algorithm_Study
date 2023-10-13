package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 스도쿠
// https://www.acmicpc.net/problem/2580
public class Main {

	private static boolean isFinished = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[9][9];
		List<Position> positions = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					positions.add(new Position(i, j));
				}
			}
		}

		dfs(map, positions, 0);
	}

	private static void dfs(int[][] map, List<Position> positions, int currentIdx) {
		if (isFinished) {
			return;
		}

		if (currentIdx >= positions.size()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j])
						.append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);

			isFinished = true;
			return;
		}

		Position position = positions.get(currentIdx);
		boolean[] isAvailable = new boolean[10];
		Arrays.fill(isAvailable, true);
		for (int i = 0; i < 9; i++) {
			isAvailable[map[position.x][i]] = false;
			isAvailable[map[i][position.y]] = false;
		}

		int startX = convertStartIndex(position.x);
		int startY = convertStartIndex(position.y);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				isAvailable[map[startX + i][startY + j]] = false;
			}
		}

		for (int i = 1; i <= 9; i++) {
			if (isAvailable[i]) {
				map[position.x][position.y] = i;
				dfs(map, positions, currentIdx + 1);
				map[position.x][position.y] = 0;
			}
		}
	}

	private static int convertStartIndex(int idx) {
		if (0 <= idx && idx < 3) {
			return 0;
		} else if (3 <= idx && idx < 6) {
			return 3;
		}
		return 6;
	}

	static class Position {
		int x;
		int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
/*
Input
0 3 5 4 6 9 2 7 8
7 8 2 1 0 5 6 0 9
0 6 0 2 7 8 1 3 5
3 2 1 0 4 6 8 9 7
8 0 4 9 1 3 5 0 6
5 9 6 8 2 0 4 1 3
9 1 7 6 5 2 0 8 0
6 0 3 7 0 1 9 5 2
2 5 8 3 9 4 7 6 0

Output
1 3 5 4 6 9 2 7 8
7 8 2 1 3 5 6 4 9
4 6 9 2 7 8 1 3 5
3 2 1 5 4 6 8 9 7
8 7 4 9 1 3 5 2 6
5 9 6 8 2 7 4 1 3
9 1 7 6 5 2 3 8 4
6 4 3 7 8 1 9 5 2
2 5 8 3 9 4 7 6 1
*/
