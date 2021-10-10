package backjoon;

import java.io.*;
import java.util.*;

public class B1325 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Node> nodeList = new ArrayList<>();
		for (int i=1; i<=N; i++) {
			nodeList.add(new Node(i));
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			nodeList.get(node2-1).edge.add(node1);
		}
		
		int max = -1;
		for (int i=1; i<=N; i++) {
			int tempResult = bfs(nodeList, i, N);
			if (max < tempResult) {
				bw = new BufferedWriter(new OutputStreamWriter(System.out));
				bw.write(i + " ");
				max = tempResult;
			}
			else if (max == tempResult) bw.write(i + " ");
		}
		
		bw.flush();
		bw.close();
		
	}
	
	static int bfs(ArrayList<Node> nodeList, int start, int N) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] check = new boolean[N];
		int count = 0;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int pop = queue.poll();
			if (!check[pop-1]) {
				count++;
				check[pop-1] = true;
				queue.addAll(nodeList.get(pop-1).edge);
			}
		}
		
		return count;
	}

}

class Node {
	int nodeId;
	ArrayList<Integer> edge;
	
	public Node(int nodeId) {
		this.nodeId = nodeId;
		edge = new ArrayList<>();
	}
}
