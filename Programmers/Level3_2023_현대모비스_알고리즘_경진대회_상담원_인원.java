import java.util.*;

class Solution {
	public int solution(int k, int n, int[][] reqs) {
		Map<Integer, List<Participant>> type = new HashMap<>();
		for (int i = 1; i <= k; i++) {
			type.put(i, new ArrayList<>());
		}

		for (int[] req : reqs) {
			type.get(req[2]).add(new Participant(req[0], req[1]));
		}

		int[][] waitingTime = new int[2][k + 1]; // 0번 index가 현재, 1번 index가 1을 더 헀을 때
		int[] numOfMento = new int[k + 1];

		// 각각 멘토가 한명씩일 때 걸리는 대기 시간 초기화
		for (int i = 1; i <= k; i++) {
			waitingTime[0][i] = calculateWaitingTime(type.get(i), 1);
			waitingTime[1][i] = calculateWaitingTime(type.get(i), 2);
			numOfMento[i] = 1;
		}

		int remainMento = n - k;
		while (remainMento > 0) {
			int maxDiff = Integer.MIN_VALUE;
			int maxIndex = 0;
			for (int i = 1; i <= k; i++) {
				int diff = waitingTime[0][i] - waitingTime[1][i];
				if (maxDiff < diff) {
					maxIndex = i;
					maxDiff = diff;
				}
			}

			numOfMento[maxIndex]++;
			waitingTime[0][maxIndex] = waitingTime[1][maxIndex];
			waitingTime[1][maxIndex] = calculateWaitingTime(type.get(maxIndex), numOfMento[maxIndex] + 1);

			remainMento--;
		}

		int answer = 0;
		for (int i = 1; i <= k; i++) {
			answer += waitingTime[0][i];
		}

		return answer;
	}

	private int calculateWaitingTime(List<Participant> participants, int numOfMento) {
		int totalWaitingTime = 0;

		Queue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < numOfMento; i++) {
			pq.add(0);
		}

		for (Participant p : participants) {
			int nextEndTime = pq.poll();
			if (p.start >= nextEndTime) {
				pq.add(p.start + p.executionTime);
			} else {
				totalWaitingTime += (nextEndTime - p.start);
				pq.add(nextEndTime + p.executionTime);
			}
		}

		return totalWaitingTime;
	}

	static class Participant {
		int start;
		int executionTime;

		public Participant(int start, int executionTime) {
			this.start = start;
			this.executionTime = executionTime;
		}
	}
}
