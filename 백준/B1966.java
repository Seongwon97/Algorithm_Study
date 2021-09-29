package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B1966 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int testCaseNum = sc.nextInt();
		
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i=0; i<testCaseNum; i++) {
			queue.clear();
			int inputNum = sc.nextInt();
			int outputPosition = sc.nextInt();
			
			for(int j=0; j< inputNum; j++) {
				queue.add(sc.nextInt());
			}
			
			for(int j=0; j< outputPosition-1; j++) {
				queue.poll();
			}
			System.out.println(queue.poll());
		}
		
	}

}
