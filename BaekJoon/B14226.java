package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

// 이모티콘
// https://www.acmicpc.net/problem/14226
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());

		Queue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(1, 0, 0));
		boolean[][] visited = new boolean[2001][2001];

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.num == S) {
				System.out.println(node.cost);
				return;
			}

			if (node.num > 0 && node.num < 2000) {
				if (!visited[node.num][node.num]) { // 복사
					visited[node.num][node.num] = true;
					queue.add(new Node(node.num, node.cost + 1, node.num));
				}

				if (!visited[node.num - 1][node.clipBoard]) {
					visited[node.num - 1][node.clipBoard] = true;
					queue.add(new Node(node.num - 1, node.cost + 1, node.clipBoard));
				}
			}

			int nextNum = node.num + node.clipBoard;
			if (nextNum > 0 && nextNum < 2000) {
				if (!visited[nextNum][node.clipBoard]) {
					visited[nextNum][node.clipBoard] = true;
					queue.add(new Node(nextNum, node.cost + 1, node.clipBoard));
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int num;
		int cost;
		int clipBoard;

		public Node(int num, int cost, int clipBoard) {
			this.num = num;
			this.cost = cost;
			this.clipBoard = clipBoard;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}
/*
Input
6

Output
5
---
Input
18

Output
8
*/
