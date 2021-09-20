package algorithm;

import java.util.*;

class NodeWeight {
	char node;
	int weight;
	

	public NodeWeight(char node, int weight) {
		this.node = node; 
		this.weight = weight;
	}
	
}

class NodeDistance  implements Comparable<NodeDistance>{
	char node; 
	int distance;
	
	public NodeDistance(char node, int distance) {
		this.node = node;
		this.distance = distance;
	}
	
	@Override
	public int compareTo(NodeDistance o) {
		// TODO Auto-generated method stub
		return this.distance > o.distance? 1:-1;
	}	
}

public class Dijkstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Node들의 연결점, 가중치를 갖고 있는 map
		HashMap<Character, NodeWeight[]> map = new HashMap<>();
		NodeWeight[] temp = new NodeWeight[3];
		temp[0] = new NodeWeight('B', 8);
		temp[1] = new NodeWeight('C', 1);
		temp[2] = new NodeWeight('D', 2);
		map.put('A', temp);

		temp = new NodeWeight[0];
		map.put('B', temp);
		
		temp = new NodeWeight[2];
		temp[0] = new NodeWeight('B', 5);
		temp[1] = new NodeWeight('D', 2);
		map.put('C', temp);

		temp = new NodeWeight[2];
		temp[0] = new NodeWeight('E', 3);
		temp[1] = new NodeWeight('F', 5);
		map.put('D', temp);
		
		temp = new NodeWeight[1];
		temp[0] = new NodeWeight('F', 1);
		map.put('E', temp);

		temp = new NodeWeight[1];
		temp[0] = new NodeWeight('A', 5);
		map.put('F', temp);
		
//		for(Character c: map.keySet()) {
//			for(NodeWeight n: map.get(c)) {
//				System.out.print(n.node + ": "+n.weight + ",  ");;				
//			}
//			System.out.println();	
//		}

		HashMap<Character, NodeDistance> result = dijkstra(map, 'A');
		for (Character c: result.keySet()) {
			System.out.println(result.get(c).node + ", " + result.get(c).distance);
		}
		
	}
	
	public static HashMap<Character, NodeDistance> dijkstra(HashMap<Character, NodeWeight[]> map, char start) {
		
		HashMap<Character, NodeDistance> distance = new HashMap<>();
		for (Character c : map.keySet()) {
			if (c == start) {
				distance.put(c, new NodeDistance(c, 0));
				continue;
			}
			distance.put(c, new NodeDistance(c, 1000)); // 무한대 대신 임시로 1000대임
		}
		
		PriorityQueue<NodeDistance> queue = new PriorityQueue<>();
		queue.offer(distance.get(start));
		
		while(!queue.isEmpty()) {
			NodeDistance currentNode = queue.poll();
			//System.out.println(currentNode.node + ", "+ currentNode.distance);
			
			if (currentNode.distance > distance.get(currentNode.node).distance)
				continue;
			
			for (NodeWeight n: map.get(currentNode.node)) {
			
				int newDistance = currentNode.distance + n.weight;
				
				// 현재 위치한 node+ 현재 node로 부터 연결된 node의 weight이 현재 연결된 node에 저장된 거리보다 작으면 값 변경
				if(newDistance < distance.get(n.node).distance) {
					distance.put(n.node, new NodeDistance(n.node, newDistance));
					queue.offer(new NodeDistance(n.node, newDistance));
				}
			}			
		}
		return distance;
	}

}
