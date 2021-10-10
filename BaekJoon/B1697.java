package baekjoon;

import java.util.*;
import java.io.*;

public class B1697 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if (N==K) System.out.println(0);
		else System.out.println(bfs(N, K));
	}
	
	static int bfs(int n, int k) {
		Queue<Integer> queue = new LinkedList<>();
		
		int[] check = new int[100001];
		queue.add(n);

		int pop;
		while(!queue.isEmpty()) {
			pop = queue.poll();
			if (pop==k) return check[pop];
			
			for (int i: new int[]{pop+1, pop-1, pop*2}) {
				if (0 <= (i) && (i) < check.length && check[i]== 0) {
					check[i] = check[pop]+1;
					queue.add(i);
				}
				
			} 
		}
		return 1;
	}
}
