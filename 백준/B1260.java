package programmers;

import java.io.*;
import java.util.*;

public class B1260 {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // Node의 수
		int M = Integer.parseInt(st.nextToken()); // edge의 수
		int V = Integer.parseInt(st.nextToken()); // 시작 Node
		
		ArrayList<Node> nodeList = new ArrayList<>();
		nodeList.add(new Node(0));
		for (int i=1; i<=N ;i++) {
			nodeList.add(new Node(i));
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			nodeList.get(node1).edge.add(node2);
			nodeList.get(node2).edge.add(node1);
		}
		
		
		// 각각 node에 연결된 list들 재정렬
		for (int i=1; i<=N; i++) {
			Collections.sort(nodeList.get(i).edge);
		}
		
		
		HashSet<Integer> result = new HashSet<>();
		result.add(V);
		dfs(N, 1, V, nodeList, result);

		sb.append("\n");
		
		result.clear();
		result.add(V);
		bfs(N, V, nodeList, result);
		
		System.out.println(sb.toString());
	}
	
	static void dfs(int maxDepth, int currentDepth, int currentNode, ArrayList<Node> nodeList, HashSet<Integer> dfsResult) throws Exception {	
		sb.append(currentNode+" ");
		
		if (maxDepth == currentDepth) return;

		for (int node: nodeList.get(currentNode).edge) {
			if (!dfsResult.contains(node)) {
				dfsResult.add(node);
				
				dfs(maxDepth, currentDepth+1, node, nodeList, dfsResult);
			}
		}	
	}
	
	static void bfs(int maxSize, int startNode, ArrayList<Node> nodeList, HashSet<Integer> bfsResult) throws Exception {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.addAll(nodeList.get(startNode).edge);
		sb.append(startNode+" ");
		
		int popNum;
		while(!queue.isEmpty()) {		
			popNum = queue.poll();
			if (!bfsResult.contains(popNum)) {
				bfsResult.add(popNum);
				if (bfsResult.size() == maxSize) {
					sb.append(popNum);
					break;
				}
				sb.append(popNum+" ");
				queue.addAll(nodeList.get(popNum).edge);
			}
		}
	}

}

class Node {
	int id; 
	ArrayList<Integer> edge = new ArrayList<>();
	
	public Node(int id) {
		this.id = id;
	}
}
