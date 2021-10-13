package baeckjoon;

import java.io.*;
import java.util.*;

public class B1774 {

	static int[] parent;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		
		// node정보들 추가
		ArrayList<Node> nodeList = new ArrayList<>();
		nodeList.add(new Node(0,0,0));
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			nodeList.add(new Node(i, x, y));
			parent[i] = i;
		}
		
		// 연결되어있는 edge들 연결
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			union(x, y);
		}
		
		// edge들 추가
		ArrayList <Edge> edgeList = new ArrayList<>();
		// priority queue를 사용하면 node를 넣을 떄마다 비교를 하기에 ArrayList로 하고 한번의 Sort사용
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				edgeList.add(new Edge(i, j, calDistance(nodeList.get(i), nodeList.get(j))));
			}
		}
		Collections.sort(edgeList);
		
		double totalDistance = 0;
		// Kruskal
		while (!edgeList.isEmpty()) {
			Edge edge = edgeList.remove(0);
			
			if(find(edge.node1) != find(edge.node2)) {
				totalDistance += edge.weight;
				System.out.println(totalDistance);
				union(edge.node1, edge.node2);
			}
		}
		
		bw.write(String.format("%.2f", totalDistance)+ "\n");
		bw.flush();
		bw.close();
		
	}
	
	static double calDistance(Node node1, Node node2) {
		int dx = node1.x - node2.x;
		int dy = node1.y - node2.y;
		
		return Math.sqrt(Math.pow(dx, 2)+ Math.pow(dy, 2));
	}
	
	static int find(int nodeId) {
		if(nodeId == parent[nodeId])
			return nodeId;
		
		return parent[nodeId] = find(parent[nodeId]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		// parentNode가 다르다면 y를 x에 연결
		if(x!=y) {
			parent[y] = x;
		}
	}

}

class Node {
	int nodeId;
	int x;
	int y;
	
	public Node(int nodeId, int x, int y) {
		this.nodeId = nodeId;
		this.x = x;
		this.y = y;
	}	
}

class Edge implements Comparable<Edge> {
	int node1; // 출발 노드
	int node2; // 도착 노드
	double weight;
	
	public Edge (int node1, int node2, double weight) {
		this.node1 = node1;
		this.node2 = node2;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.weight < o.weight? -1:1;
	}
}
