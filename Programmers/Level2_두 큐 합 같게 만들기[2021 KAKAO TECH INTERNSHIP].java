import java.util.*;

class Solution {
	public int solution(int[] queue1, int[] queue2) {
		long sum1 = 0;
		long sum2 = 0;
		int answer = 0;

		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		for (int i = 0; i < queue1.length; i++) {
			sum1 += queue1[i];
			sum2 += queue2[i];
			q1.add(queue1[i]);
			q2.add(queue2[i]);
		}

		while (sum1 != sum2 && (!q1.isEmpty() || !q2.isEmpty())) {
			if (answer > (queue1.length + queue2.length) * 2) {
				return -1;
			}

			if (sum1 > sum2) {
				int num = q1.poll();
				q2.add(num);
				sum1 -= num;
				sum2 += num;
			} else {
				int num = q2.poll();
				q1.add(num);
				sum1 += num;
				sum2 -= num;
			}

			answer++;
		}

		return answer;
	}
}
