import java.util.*;

// https://school.programmers.co.kr/learn/courses/15009/lessons/121689
class Solution {
	public int solution(int[] menu, int[] order, int k) {
		int answer = 0;
		int currentTime = 0;
		int nextFinishTime = 0;
		Queue<Integer> pq = new PriorityQueue<>(); // 음료 제작이 끝나는 시간 저장
		for (int i = 0; i < order.length; i++) {
			while (!pq.isEmpty() && pq.peek() <= currentTime) {
				pq.poll();
			}

			if (nextFinishTime < currentTime) { // 손님이 온 현재 시간에 밀린 음료가 없는 경우
				nextFinishTime = currentTime;
			}
			nextFinishTime += menu[order[i]];
			pq.add(nextFinishTime);
			currentTime += k;
			answer = Math.max(answer, pq.size());
		}

		return answer;
	}
}
