package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 뱀과 사다리 게임
// https://www.acmicpc.net/problem/16928
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] move = new int[101];
		boolean[] visited = new boolean[101];
		for (int i = 0; i <= 100; i++) {
			move[i] = i;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			move[x] = y;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			move[u] = v;
		}

		int answer = 0;
		Queue<Turn> queue = new LinkedList<>();
		queue.add(new Turn(1, 0));
		visited[1] = true;
		while (!queue.isEmpty()) {
			Turn turn = queue.poll();

			if (turn.currentPosition == 100) {
				answer = turn.numOfDraws;
				break;
			}

			for (int i = 1; i <= 6; i++) {
				if (turn.currentPosition + i > 100) {
					continue;
				}

				int nextPosition = move[turn.currentPosition + i];

				if (visited[nextPosition]) {
					continue;
				}
				queue.add(new Turn(nextPosition, turn.numOfDraws + 1));
				visited[nextPosition] = true;
			}
		}

		System.out.println(answer);
	}

	static class Turn {
		int currentPosition;
		int numOfDraws;

		public Turn(int currentPosition, int numOfDraws) {
			this.currentPosition = currentPosition;
			this.numOfDraws = numOfDraws;
		}
	}
}
/*
Input
3 7
32 62
42 68
12 98
95 13
97 25
93 37
79 27
75 19
49 47
67 17

Output
3
*/
