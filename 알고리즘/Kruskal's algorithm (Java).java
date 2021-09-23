package algorithm;
import java.util.*;


public class Kruskal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] vertices = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		HashMap<Character, Character> parent = new HashMap<>();
		HashMap<Character, Integer> rank = new HashMap<>();
		for (char c:vertices) {
			parent.put(c, c);
			rank.put(c, 0);
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
		
		kruskal(edges, rank, parent);
	}
	
	// 2개의 집합을 합침
	public static void union(char node1, char node2, HashMap<Character, Integer> rank, HashMap<Character, Character> parent) {
		if (rank.get(node1) > rank.get(node2)) {
			parent.put(node2, node1);
		}
		else {
			parent.put(node1, node2);
			if (rank.get(node1) == rank.get(node2)) {
				rank.put(node2, rank.get(node2)+1);
			}
		}

	}
	
	public static char find(HashMap<Character, Character> parent, char n) {
		if (parent.get(n) != n)
			parent.put(n, find(parent, parent.get(n)));
		return parent.get(n);
		
	}
	
	public static ArrayList<Edge> kruskal(PriorityQueue<Edge> edges, HashMap<Character, Integer> rank, HashMap<Character, Character> parent) {
		ArrayList<Edge> result = new ArrayList<>();
		Edge temp;
		int len = edges.size();
		for (int i=0; i<len; i++) {
			temp = edges.poll();
			if (find(parent, temp.node1) != find(parent, temp.node2)) {
				union(find(parent, temp.node1), find(parent, temp.node2), rank, parent);
				result.add(temp);
				System.out.println(temp.weight+", "+temp.node1+", "+ temp.node2);

			}
		}
		return result;
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
