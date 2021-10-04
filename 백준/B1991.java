package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Node{
	char nodeId;
	char leftNode;
	char rightNode;
	
	public Node(char nodeId, char leftNode, char rightNode) {
		this.nodeId = nodeId;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
}

public class B1991 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character, Node> map = new HashMap<>();
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		char id;
		
		Node head = new Node('.', '.', '.');
		Node temp;
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			id = st.nextToken().charAt(0);
			
			temp = new Node(id, st.nextToken().charAt(0), st.nextToken().charAt(0));
			map.put(id, temp);
			if(i==0) head = temp;
		}
//		System.out.println(map.get(head.leftNode).nodeId);
//		System.out.println(map.get(head.leftNode).leftNode);
//		System.out.println(map.get(head.leftNode).rightNode);

		
		preorder(head, map);
		sb.append("\n");
		inorder(head, map);
		sb.append("\n");
		postorder(head, map);
		sb.append("\n");
		System.out.print(sb.toString());
		
	}
	
	static void preorder(Node head, HashMap<Character, Node> map) {
		sb.append(head.nodeId);
		if (head.leftNode != '.') preorder(map.get(head.leftNode), map);
		if (head.rightNode != '.') preorder(map.get(head.rightNode), map);
	}
	
	static void inorder(Node head, HashMap<Character, Node> map) {
		if (head.leftNode != '.') inorder(map.get(head.leftNode), map);
		sb.append(head.nodeId);
		if (head.rightNode != '.') inorder(map.get(head.rightNode), map);
	}
	static void postorder(Node head, HashMap<Character, Node> map) {
		if (head.leftNode != '.') postorder(map.get(head.leftNode), map);
		if (head.rightNode != '.') postorder(map.get(head.rightNode), map);
		sb.append(head.nodeId);
	}

}
