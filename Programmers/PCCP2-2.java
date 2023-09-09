import java.util.*;

// https://school.programmers.co.kr/learn/courses/15009/lessons/121688
class Solution {
	public int solution(int[] ability, int number) {
		int answer = 0;

		Queue<Integer> pq = new PriorityQueue<>();
		for (int a : ability) {
			pq.add(a);
		}

		for (int i = 0; i < number; i++) {
			int worker1 = pq.poll();
			int worker2 = pq.poll();
			pq.add(worker1 + worker2);
			pq.add(worker1 + worker2);
		}

		while (!pq.isEmpty()) {
			answer += pq.poll();
		}

		return answer;
	}
}
