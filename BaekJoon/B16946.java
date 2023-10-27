package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// 벽 부수고 이동하기 4
// https://www.acmicpc.net/problem/16946
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] matrix = new int[N][M];
		int[][] result = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
				result[i][j] = matrix[i][j];
			}
		}

		// 구역별로 차지하는 칸을 구하기
		int groupId = 2;
		int[] groupInfo = new int[N * M + 2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] == 0) {
					int numOfBlank = bfs(matrix, i, j, groupId);
					groupInfo[groupId] = numOfBlank;
					groupId++;
				}
			}
		}

		// 각각 벽을 없앴을 때, 인접한 구역의 칸들을 이용하여 만들어지는 칸의 수 구하기
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				if (matrix[x][y] == 1) {
					result[x][y] = findNumOfSpace(x, y, N, M, matrix, groupInfo);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				sb.append(result[x][y]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int bfs(int[][] matrix, int x, int y, int groupId) {
		int N = matrix.length;
		int M = matrix[0].length;

		int numOfBlank = 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));
		matrix[x][y] = groupId;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};

		while (!queue.isEmpty()) {
			numOfBlank++;
			Node node = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || matrix[nx][ny] != 0) {
					continue;
				}
				matrix[nx][ny] = groupId;
				queue.add(new Node(nx, ny));
			}
		}
		return numOfBlank;
	}

	private static int findNumOfSpace(int x, int y, int N, int M, int[][] matrix, int[] groupInfo) {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};

		int temp = 1;
		List<Integer> visited = new ArrayList<>();
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M || matrix[nx][ny] == 1) {
				continue;
			}

			int id = matrix[nx][ny];
			if (!visited.contains(id)) {
				temp += groupInfo[id];
				visited.add(id);
			}

		}
		return temp % 10;
	}

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
/*
Input
3 3
101
010
101

Output
303
050
303
----
Input
4 5
11001
00111
01010
10101

Output
46003
00732
06040
50403
*/
