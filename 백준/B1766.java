package baekjoon;

import java.io.*;
import java.util.*;

public class B1766 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		int[] inDegree = new int[n+1]; // node로 연결된 node의 수
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		// n개의 문제 추가
		for (int i=0; i<=n; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int problem1 = Integer.parseInt(st.nextToken());
			int problem2 = Integer.parseInt(st.nextToken());
			
			list.get(problem1).add(problem2);

			inDegree[problem2]++;
		}
		
		for(int i=1; i<=n; i++) {
			if(inDegree[i] == 0)
				queue.offer(i);
		}
		
		while (!queue.isEmpty()) {
			int problem = queue.poll();
			bw.write(problem+" ");
			for (int i: list.get(problem)) {
				inDegree[i]--;
				if (inDegree[i] == 0) {
					queue.offer(i);
				}
			}
		}
		
		
		bw.flush();
		bw.close();
		
	}
}
