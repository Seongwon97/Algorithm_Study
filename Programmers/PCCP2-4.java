import java.util.*;

// https://school.programmers.co.kr/learn/courses/15009/lessons/121690
class Solution {
	public int solution(int n, int m, int[][] hole) {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};

		boolean[][][] visited = new boolean[m + 1][n + 1][2]; // 마지막은 chance를 쓴 여부
		boolean[][] hasHole = new boolean[m + 1][n + 1];
		for (int[] h : hole) {
			hasHole[h[1]][h[0]] = true;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(1, 1, 1, 0));
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.x == m && node.y == n) {
				return node.weight;
			}

			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if (nx < 1 || nx > m || ny < 1 || ny > n || visited[nx][ny][node.hasChance] || hasHole[nx][ny]) {
					continue;
				}

				visited[nx][ny][node.hasChance] = true;
				queue.add(new Node(nx, ny, node.hasChance, node.weight + 1));
			}

			if (node.hasChance == 1) {
				for (int i = 0; i < 4; i++) {
					int nx = node.x + (dx[i] * 2);
					int ny = node.y + (dy[i] * 2);
					if (nx < 1 || nx > m || ny < 1 || ny > n || visited[nx][ny][0] || hasHole[nx][ny]) {
						continue;
					}

					visited[nx][ny][0] = true;
					queue.add(new Node(nx, ny, 0, node.weight + 1));
				}
			}
		}

		return -1;
	}

	static class Node {
		int x;
		int y;
		int hasChance; // 1 은 chance 보유, 0은 미보유
		int weight; // 이동 횟수

		public Node(int x, int y, int hasChance, int weight) {
			this.x = x;
			this.y = y;
			this.hasChance = hasChance;
			this.weight = weight;
		}
	}
}
