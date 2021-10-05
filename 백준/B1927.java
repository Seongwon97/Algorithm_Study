package baekjoon;

import java.io.*;
import java.util.PriorityQueue;

public class B1927 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> heap = new PriorityQueue<>();

		
		for (int i=0; i<n; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if (x != 0) {
				heap.offer(x);
			}
			else {
				if (heap.peek()!=null) {
					bw.write(heap.poll()+"\n");
					//System.out.println(heap.poll());
				}
				else {
					bw.write(0+"\n");
					//System.out.println(0);
				}
			}
		}
		bw.flush();
		bw.close();
	}
}
