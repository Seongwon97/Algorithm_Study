package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1647 {

	static int N; // 집의 개수
	static int M; // 길의 개수
	static ArrayList<Edge> edgeList = new ArrayList<>();
 	static int[] parent;
 	static int result = 0;
 	static int lastConnect; // 마지막으로 연결된 길의 weight저장
 	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		for (int i=1; i<=N; i++) parent[i] = i;
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			edgeList.add(new Edge(A, B, C));
		}
		
		Collections.sort(edgeList);
		
		kruskal();
		result -= lastConnect;
		System.out.println(result);
		
	}
	
	static void kruskal() {
		for (Edge e: edgeList) {
			union(e);
		}
	}
	
	
	static int find(int nodeId) {
		if (parent[nodeId] == nodeId) return nodeId;
		else return parent[nodeId] = find(parent[nodeId]);
	}
	
	static void union(Edge e) {
		int node1 = find(e.node1);
		int node2 = find(e.node2);
		if (node1 != node2) {
			result += e.weight;
			lastConnect = e.weight;
			parent[node1] = node2;
		}
	}
	
	
	
	static class Edge implements Comparable<Edge> {
		int node1;
		int node2;
		int weight;
		
		public Edge(int node1, int node2, int weight) {
			this.node1 = node1;
			this.node2 = node2;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight < o.weight ? -1:1;
		}
	}

}