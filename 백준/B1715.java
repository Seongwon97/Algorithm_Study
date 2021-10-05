package baekjoon;

import java.io.*;
import java.util.PriorityQueue;

public class B1715 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		int result = 0;
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i=0; i<n; i++) {
			queue.offer(Integer.parseInt(br.readLine()));
		}
		
		while (queue.size()!=1) {
			int n1 = queue.poll();
			int n2 = queue.poll();
			
			result += (n1+n2);
			
			
			queue.offer(n1+n2);
		}
		
		System.out.println(result);
	}

}
