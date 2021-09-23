package algorithm;
import java.util.*;


public class Kruskal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] vertices = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		HashMap<Character, Node> nodes = new HashMap<>();
		for (char c: vertices) {
			nodes.put(c, new Node(c, c, 0));
		}
		
		PriorityQueue<Edge> edges = new PriorityQueue<>();
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
		
		kruskal(edges, nodes);
	}
	
	// 2개의 집합을 합침
	public static void union(char node1, char node2, HashMap<Character, Node> nodes) {
		if (nodes.get(node1).rank > nodes.get(node2).rank) 
			nodes.put(node2, new Node(node2, nodes.get(node1).rootNode, nodes.get(node1).rank));
		else if (nodes.get(node1).rank == nodes.get(node2).rank)
			nodes.put(node2, new Node(node2, nodes.get(node1).rootNode, nodes.get(node1).rank+1));
		else // node2의 rank가 높은 경우 
			nodes.put(node1, new Node(node1, nodes.get(node2).rootNode, nodes.get(node2).rank));
	}
	
	
	public static ArrayList<Edge> kruskal(PriorityQueue<Edge> edges, HashMap<Character, Node> nodes) {
		ArrayList<Edge> result = new ArrayList<>();
		Edge temp;
		for (int i=0; i<edges.size(); i++) {
			temp = edges.poll();
			if (nodes.get(temp.node1).rootNode != nodes.get(temp.node2).rootNode) {
				union(temp.node1, temp.node2, nodes);
				result.add(temp);
				System.out.println(temp.weight+", "+temp.node1+", "+ temp.node2);
			}
		}
		return result;
	}

}

class Node {
	char nodeId;
	char rootNode;
	int rank;
	public Node(char nodeId, char rootNode, int rank) {
		this.nodeId = nodeId;
		this.rootNode = rootNode;
		this.rank = rank;
	}
}


class Edge implements Comparable<Edge> {
	int weight;
	char parent;
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
