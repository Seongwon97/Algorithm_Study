package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B13913 {
	
	static boolean[] visited = new boolean[100001];
	static int[] parent = new int[100001];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int subin = Integer.parseInt(st.nextToken());
		int sister = Integer.parseInt(st.nextToken());
		
		visited[subin] = true;
		bfs(subin, sister);
		
		Stack<Integer> stack = new Stack<>();
		stack.add(sister);
		int past = sister;
		
		while (past != subin) {
			past = parent[past];
			stack.add(past);
		}
		
		bw.write((stack.size()-1) + "\n");
		while(!stack.isEmpty()) {
			bw.write(stack.pop() + " ");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	static void bfs(int subin, int sister) {	
		Queue<Integer> queue = new LinkedList<>();
		queue.add(subin);
		
		int next;
		int current;
		
		while(!queue.isEmpty()) {
			current = queue.poll();
			
			if (current == sister) break;
			
			for (int i=0; i<3; i++) {
				if (i == 0) next = current + 1;
				else if (i == 1) next = current - 1;
				else next = current * 2;
				
				if (0 > next || next > 100000) continue;
				
				if (!visited[next]) {
					queue.add(next);
					visited[next] = true;
					parent[next] = current;
				}
			}
		}
	}

}
