package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

// 가운데를 말해요
// https://www.acmicpc.net/problem/1655
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> minHeap = new PriorityQueue<>();
		Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			if (maxHeap.size() <= minHeap.size()) {
				maxHeap.add(input);
			} else {
				minHeap.add(input);
			}

			if (!minHeap.isEmpty() && !maxHeap.isEmpty() && (minHeap.peek() < maxHeap.peek())) {
				minHeap.add(maxHeap.poll());
				maxHeap.add(minHeap.poll());
			}

			sb.append(maxHeap.peek())
				.append("\n");
		}

		System.out.println(sb);
	}
}
/*
Input
7
1
5
2
10
-99
7
5

Output
1
1
2
2
2
2
5
*/
