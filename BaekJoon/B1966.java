package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B1966 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int testCaseNum = sc.nextInt();
		
		
		ArrayList<Integer> queue = new ArrayList<>();
		for (int i=0; i<testCaseNum; i++) {
			int count = 0;
			queue.clear();
			int inputNum = sc.nextInt();
			int position = sc.nextInt();
			
			for(int j=0; j< inputNum; j++) {
				queue.add(sc.nextInt());
			}
			
			int len = queue.size();
			
			
			while(queue.size() != 0) {

				
				int max = Collections.max(queue);
				
//				for (int n: queue) {
//					System.out.println(n);
//				}
				int removeNum = queue.remove(0);
				
//				System.out.println();
//				for (int n: queue) {
//					System.out.println(n);
//				}
				if (removeNum != max) {
					queue.add(removeNum);
					if (position == 0) position = queue.size()-1;
					else position--;
				}
				else {
					count++;
					if (position == 0) {
						System.out.println("count: "+count);
						break;
					}
					position--;
				}
				
//				System.out.println();
//				for (int n: queue) {
//					System.out.println(n);
//				}
				
			}
		}
		
	}

}
