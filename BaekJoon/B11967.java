package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 불켜기
// https://www.acmicpc.net/problem/11967
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Position>[][] matrix = new ArrayList[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				matrix[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			matrix[x][y].add(new Position(a, b));
		}

		boolean[][] isTurnOn = new boolean[N + 1][N + 1];
		isTurnOn[1][1] = true;

		int answer = 1 + bfs(N, matrix, isTurnOn);

		System.out.println(answer);
	}

	private static int bfs(int N, List<Position>[][] matrix, boolean[][] isTurnOn) {
		int answer = 0;
		Queue<Position> toVisit = new LinkedList<>();
		toVisit.add(new Position(1, 1));
		boolean[][] visited = new boolean[N + 1][N + 1];

		visited[1][1] = true;

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		while (!toVisit.isEmpty()) {
			Position p = toVisit.poll();

			for (Position position : matrix[p.x][p.y]) {
				if (!isTurnOn[position.x][position.y]) {
					isTurnOn[position.x][position.y] = true;
					answer++;
				}
			}

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 1 || nx > N || ny < 1 || ny > N || visited[nx][ny] || !isTurnOn[nx][ny]) {
					continue;
				}

				toVisit.add(new Position(nx, ny));
				visited[nx][ny] = true;
			}
		}

		if (answer > 0) { // 새로 킨 전구가 있다면
			answer += bfs(N, matrix, isTurnOn);
		}
		return answer;
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
