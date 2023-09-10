import java.util.*;

// https://school.programmers.co.kr/learn/courses/15008/lessons/121686#qna
class Solution {
	public long[] solution(int[][] program) {
		long[] answer = new long[11];

		Queue<Process> callTimePq = new PriorityQueue<>(Comparator.comparing(i -> i.callTime));
		Queue<Process> readyQueue = new PriorityQueue<>((p1, p2) -> {
			if (p1.priority == p2.priority) {
				return p1.callTime - p2.callTime;
			}
			return p1.priority - p2.priority;
		});

		for (int[] p : program) {
			callTimePq.add(new Process(p[1], p[0], p[2]));
		}

		long currentTime = 0;
		while (!callTimePq.isEmpty() || !readyQueue.isEmpty()) {
			// ReadyQueue가 비어있을 경우 이후 가장 빨리 들어오는 시간대의 Process추가
			if (readyQueue.isEmpty()) {
				Process firstCall = callTimePq.poll();
				readyQueue.add(firstCall);
				while (!callTimePq.isEmpty() && callTimePq.peek().callTime == firstCall.callTime) {
					readyQueue.add(callTimePq.poll());
				}
				currentTime = firstCall.callTime;
			}

			// ReadyQueue에 있는 우선순위가 빠른 프로세스 실행
			Process currentProcess = readyQueue.poll();
			long waitingTime = currentTime - currentProcess.callTime;
			answer[currentProcess.priority] += waitingTime;
			currentTime += currentProcess.executionTime;

			// 현재 시간 이전에 호출된 프로세스를 ReadyQueue로 이동
			while (!callTimePq.isEmpty() && callTimePq.peek().callTime <= currentTime) {
				readyQueue.add(callTimePq.poll());
			}
		}

		answer[0] = currentTime;
		return answer;
	}

	static class Process {
		int callTime;
		int priority;
		int executionTime;

		public Process(int callTime, int priority, int executionTime) {
			this.callTime = callTime;
			this.priority = priority;
			this.executionTime = executionTime;
		}
	}
}
