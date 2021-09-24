package algorithm;
import java.util.*;
public class Prim_improved {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] vertices = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

		ArrayList<Edge> edges = new ArrayList<>();
		edges.add(new Edge(7, 'A', 'B'));
		edges.add(new Edge(5, 'A', 'D'));
		edges.add(new Edge(7, 'B', 'A'));
		edges.add(new Edge(8, 'B', 'C'));
		edges.add(new Edge(9, 'B', 'D'));
		edges.add(new Edge(7, 'B', 'E'));
		edges.add(new Edge(8, 'C', 'B'));
		edges.add(new Edge(5, 'C', 'E'));
		edges.add(new Edge(5, 'D', 'A'));
		edges.add(new Edge(9, 'D', 'B'));
		edges.add(new Edge(7, 'D', 'E'));
		edges.add(new Edge(6, 'D', 'F'));
		edges.add(new Edge(7, 'E', 'B'));
		edges.add(new Edge(5, 'E', 'C'));
		edges.add(new Edge(7, 'E', 'D'));
		edges.add(new Edge(8, 'E', 'F'));
		edges.add(new Edge(9, 'E', 'G'));
		edges.add(new Edge(6, 'F', 'D'));
		edges.add(new Edge(8, 'F', 'E'));
		edges.add(new Edge(11, 'F', 'G'));
		edges.add(new Edge(9, 'G', 'E'));
		edges.add(new Edge(11, 'G', 'F'));
		
		prim('A' ,vertices, edges);
	}
	
	public static ArrayList<Node> prim(char start, char[] vertices, ArrayList<Edge> edges) {
		ArrayList<Node> mst = new ArrayList<>();
		
		// 각각 node에 연결된 edge들을 저장
		HashMap<Character, ArrayList<Edge>> adjacentEdges = new HashMap<>();
		for (char v : vertices) {
			adjacentEdges.put(v, new ArrayList<Edge>());
		}
		for (Edge e: edges) {
			adjacentEdges.get(e.node1).add(e);
		}

		
		
		// node의 정보를 관리하는 Map 생성
		ArrayList<Node> nodeInfo = new ArrayList<>();
		for (char v : vertices) {
			if (v == start) {
				nodeInfo.add(new Node(v, 0));
				continue;
			}
			nodeInfo.add(new Node(v, 100));
		}
		
		
		Node temp;
		while (!nodeInfo.isEmpty()) {
			Collections.sort(nodeInfo);
			temp = nodeInfo.remove(0);
			mst.add(temp);
			System.out.println(temp.weight + ", " + temp.nodeId + ", " + temp.connectNode);
			
			for (Edge e: adjacentEdges.get(temp.nodeId)) {
				nodeInfo.forEach((value)-> {
					if ((value.nodeId == e.node2) && (value.weight > e.weight)) {
						value.weight = e.weight;
						value.connectNode = e.node1;
						//System.out.println("nodeId: "+value.nodeId +", node weight: "+ value.weight +", connected node: "+value.connectNode);
					}
				});
				
			}
			
		}
		return mst;
		
	}
	

}

class Edge implements Comparable<Edge> {
	int weight;
	char node1;
	char node2;
	
	public Edge(int weight, char node1, char node2) {
		this.weight = weight;
		this.node1 = node1;
		this.node2 = node2;
	}
	
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.weight < o.weight? -1:1;
	}
}

class Node implements Comparable<Node>{
	char nodeId;
	int weight;
	char connectNode;
	
	public Node(char nodeId, int weight) {
		this.nodeId = nodeId;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.weight < o.weight? -1:1;
	}
}

