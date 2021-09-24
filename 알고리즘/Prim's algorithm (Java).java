package algorithm;
import java.util.*;
public class Prim {

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
	
	public static ArrayList<Edge> prim(char start, char[] vertices, ArrayList<Edge> edges) {
		ArrayList<Edge> mst = new ArrayList<>();
		
		// 각각 node에 연결된 edge들을 저장
		HashMap<Character, ArrayList<Edge>> adjacentEdges = new HashMap<>();
		for (char v : vertices) {
			adjacentEdges.put(v, new ArrayList<Edge>());
		}
		for (Edge e: edges) {
			adjacentEdges.get(e.node1).add(e);
		}

		
		// 현재 연결된 Node의 Set
		HashSet<Character> connectedNode = new HashSet<Character>();
		connectedNode.add(start);
		
		// 연결딘 Node Set에 연결되어 있는 edge들
		PriorityQueue<Edge> candidateEdge = new PriorityQueue<>();
		candidateEdge.addAll(adjacentEdges.get(start));
		
		Edge temp;
		while (!candidateEdge.isEmpty()) {
			// candidateEdge에 값이 있을 경우 계속 실행되며
			// 연결된 edge중에서 weight이 가장 작은 edge를 연결을 시도하는데
			// 해당 edge의 끝 점에 연결된 node가 현재 연결된 node에 없으면 연결하고
			// 연결된 node에 해당 node가 이미 속해있다면 pass한다.
			temp = candidateEdge.poll(); 
			if (!connectedNode.contains(temp.node2)) {
				connectedNode.add(temp.node2);
				mst.add(temp);
				System.out.println(temp.weight + ", " + temp.node1 + ", " + temp.node2);		
			}
			for (Edge e : adjacentEdges.get(temp.node2)) {
				if (!connectedNode.contains(e.node2)) {
					candidateEdge.add(e);
				}			
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

