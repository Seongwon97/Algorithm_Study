package baekjoon;

import java.io.*;
import java.util.*;

public class B1781 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int maxDeadline = 0;
		StringTokenizer st;
		PriorityQueue<Problem> queue = new PriorityQueue<>();
		for (int i=0; i< N;i++) {
			st = new StringTokenizer(br.readLine());
			int deadline = Integer.parseInt(st.nextToken());
			int reward = Integer.parseInt(st.nextToken());
			queue.add(new Problem(i+1, deadline, reward));

		}

		
		PriorityQueue<Integer> resultQueue = new PriorityQueue<>();
		for (int i=1; i<=N; i++) {
			Problem p = queue.poll();
			resultQueue.add(p.reward);
			
			if (p.deadline < resultQueue.size()) {
				resultQueue.poll();
			}
		}
		
		int result = 0;
		while(!resultQueue.isEmpty()) {
			int poll = resultQueue.poll();
			result += poll;
		}
		System.out.println(result);
	}

}
class Problem implements Comparable<Problem>{
	int id;
	int deadline;
	int reward;
	
	public Problem(int id, int deadline, int reward) {
		this.id = id;
		this.deadline = deadline;
		this.reward = reward;
	}

	@Override
	public int compareTo(Problem o) {
		// TODO Auto-generated method stub

		return this.deadline < o.deadline? -1:1;
	}
}
