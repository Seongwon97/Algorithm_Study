package backjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2606 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int computerNum = Integer.parseInt(br.readLine());
		int connectNum = Integer.parseInt(br.readLine());
		
		ArrayList<Node> nodeList = new ArrayList<>();
		
		for (int i=1; i<=computerNum; i++) {
			nodeList.add(new Node(i));
		}
		
		StringTokenizer st;
		for (int i=0; i<connectNum; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			nodeList.get(node1-1).edge.add(node2);
			nodeList.get(node2-1).edge.add(node1);
		}
	
		System.out.println(bfs(nodeList, 1));
		
	}
	static int bfs(ArrayList<Node> grapgh, int start) {
		Queue<Integer> queue = new LinkedList<>();
		HashSet<Integer> set = new HashSet<>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int pop = queue.poll();
			if (!set.contains(pop)) {
				set.add(pop);
				queue.addAll(grapgh.get(pop-1).edge);
			}
		}

		return set.size()-1;	
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
