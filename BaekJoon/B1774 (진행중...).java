package baekjoon;

// 연결 edge정보를 받고 해당 edge적용을 한 후 길이출력해야함
import java.util.*;
import java.io.*;

public class B1774 {
	static ArrayList<Node> nodeList;
	static int[] rank;
	static int[] parent;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		nodeList = new ArrayList<>();
		nodeList.add(new Node(0, 0, 0));
 		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			nodeList.add(new Node(i, x, y));
		}
 		
 		rank = new int[N+1];
 		parent = new int[N+1];
 		for (int i=0; i<=N; i++) {
 			parent[i] = i;
 		}
		
 		PriorityQueue<Edge> edgeList = new PriorityQueue<>();
 		Edge edge;
 		for (int i=1; i<=N; i++) {
 			for (int j=1; j<=N; j++) {
 				edge = new Edge(i, j);
 				edge.distance = calDistance(i, j);
 			}
 		}
 		
 		
 		// 여기서부터 연결된 node값을 받아야함
//		for (int i=0; i<M; i++) {
//			st = new StringTokenizer(br.readLine());
//			
//		}
 		kruskal(edgeList);
	}
	static double calDistance(int node1, int node2) {
		int xd = nodeList.get(node1).x - nodeList.get(node2).x;
		int yd = nodeList.get(node1).y - nodeList.get(node2).y;
		return Math.sqrt(Math.pow(xd,2) + Math.pow(yd, 2));
	}
	
	static int find(int nodeId) {
		if (parent[nodeId] != nodeId)
			parent[nodeId] = find(parent[parent[nodeId]]);
		return parent[nodeId];
	}
	
	static void union(int node1, int node2) {
		if (rank[node1]> rank[node2]) {
			parent[node2] = node1;
		}
		else {
			parent[node1] = node2;
			if(rank[node1] == rank[node2]) {
				rank[node2] = rank[node2]+1;
			}
		}
	}
	static ArrayList<Edge> kruskal(PriorityQueue<Edge> edgeList) {
		ArrayList<Edge> result = new ArrayList<>();
		Edge temp;
		while (!edgeList.isEmpty()) {
			temp = edgeList.poll();
			if (find(temp.node1)!=find(temp.node2)) {
				union(find(temp.node1), find(temp.node2));
				result.add(temp);
				System.out.println(temp.node1+", "+temp.node2+", "+temp.distance);
			}
		}
		return result;
	}

}
class Node {
	int id;
	int x;
	int y;
	
	public Node(int id, int x, int y) {
		this.id =id;
		this.x = x;
		this.y = y;
	}
}

class Edge implements Comparable<Edge> {
	int node1;
	int node2;
	double distance;
	
	public Edge(int node1, int node2) {
		this.node1 = node1;
		this.node2 = node2;
	}
	
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.distance < o.distance? -1:1;
	}
}