import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


class Node {
	int nodeId;
	int leftNode;
	int rightNode;
	int parent = -1;
	int depth = -1;
	
	public Node(int nodeId) {
		this.nodeId = nodeId;
	}
}

public class Main {
	static ArrayList<Integer> explore = new ArrayList<>();
	static HashMap<Integer, ArrayList<Integer>> depthNode = new HashMap<>();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Node> treeInfo = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());
		
		for (int i=0; i<= n; i++) {
			treeInfo.add(new Node(i));
		}
		
		
		StringTokenizer st;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int nodeId = Integer.parseInt(st.nextToken());
			int leftNode = Integer.parseInt(st.nextToken());
			int rightNode = Integer.parseInt(st.nextToken());
			treeInfo.get(nodeId).leftNode = leftNode;
			treeInfo.get(nodeId).rightNode = rightNode;
			
			if (leftNode != -1) treeInfo.get(leftNode).parent = nodeId;
			if (rightNode != -1) treeInfo.get(rightNode).parent = nodeId;
		}
		
		int rootNode = -1;
		for (int i=1; i<=n; i++) {
			if (treeInfo.get(i).parent == -1) {
				rootNode = i;
			}
		}
		

		inOrder(treeInfo, rootNode, 0);
		
		int maxDepth = -1;
		int maxLen = -1;
		for (int i=1; i<=depthNode.size(); i++) {
			int len = findWidth(i);

			if (len > maxLen) {
				maxDepth = i;
				maxLen = len;
			}
		}
		
		System.out.println(maxDepth+ " "+ maxLen);

	}
	static void inOrder(ArrayList<Node> treeInfo, int parent, int parentDepth) {
		int left = treeInfo.get(parent).leftNode;
		int right = treeInfo.get(parent).rightNode;
		
		if (treeInfo.get(parent).depth == -1) treeInfo.get(parent).depth = parentDepth+1;
		
		if (depthNode.containsKey(parentDepth+1)) {
			depthNode.get(parentDepth+1).add(parent);
		}
		else {
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(parent);
			depthNode.put(parentDepth+1, temp);
		}
		
		
		if (left != -1) inOrder(treeInfo, left, parentDepth+1);
		explore.add(parent);
		if (right != -1) inOrder(treeInfo, right, parentDepth+1);
		

	}
	
	static int findWidth(int depth) {
		ArrayList<Integer> depthList = depthNode.get(depth);
		int start = depthList.get(0);
		int end = depthList.get(depthList.size()-1);
		
		return explore.indexOf(end) - explore.indexOf(start) + 1; 
	}
	

}
