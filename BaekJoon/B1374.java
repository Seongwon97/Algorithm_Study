package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// 강의실
// https://www.acmicpc.net/problem/1374
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Time> times = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String[] info = br.readLine().split(" ");
			times.add(new Time(Integer.parseInt(info[0]), Integer.parseInt(info[1]), Integer.parseInt(info[2])));
		}
		Collections.sort(times);

		Queue<Integer> q = new PriorityQueue<>();

		int result = 1;

		for (int i = 0; i < n; i++) {
			while (!q.isEmpty() && q.peek() <= times.get(i).start) {
				q.poll();
			}
			q.offer(times.get(i).end);
			result = Math.max(result, q.size());
		}

		System.out.println(result);
	}

	static class Time implements Comparable<Time> {
		int num;
		int start;
		int end;

		public Time(int num, int start, int end) {
			this.num = num;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time t) {
			if (this.start == t.start) {
				return this.end - t.end;
			}
			return this.start - t.start;
		}
	}
}
/*
Input
8
6 15 21
7 20 25
1 3 8
3 2 14
8 6 27
2 7 13
4 12 18
5 6 20

Output
5
*/
